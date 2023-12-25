package com.example.demo3.config;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.core.MethodParameter;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.example.demo3.common.domain.MyException;
import com.example.demo3.common.domain.ResVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(basePackages = {"com.example.demo3.sample.controller"})
public class ResAdvice implements ResponseBodyAdvice<Object>{

    //---------------------------------------------
    // Step 1 - Handler
    //---------------------------------------------
	// DataAccessException
	// org.springframework.dao.DataIntegrityViolationException: could not execute statement [(conn=449) Cannot delete or update a parent row: a foreign key constraint fails (`demo_dev`.`token`, CONSTRAINT `FKe32ek7ixanakfqsdaokm4q9y2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`))] [delete from user where id=?]; SQL [delete from user where id=?]; constraint [null]
	// org.springframework.dao.DataIntegrityViolationException
	//
	//	org.springframework.dao.DuplicateKeyException: 
	//		### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: (conn=479) Duplicate entry '102' for key 'PRIMARY'
	//		### The error may exist in file [BoardMapper.xml]
	//		### The error may involve com.example.demo3.sample.repository.BoardMapper.insertUser-Inline
	//		### The error occurred while setting parameters
	//		### SQL: INSERT INTO user (id, email) VALUES (?, "aaa")
	//		### Cause: java.sql.SQLIntegrityConstraintViolationException: (conn=479) Duplicate entry '102' for key 'PRIMARY'
	//		; (conn=479) Duplicate entry '102' for key 'PRIMARY'

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<?> handleDataAccessException(DataAccessException ex) {
    	ResVO res = new ResVO();
    	res.setErrCode(ex.getClass().getName());
    	res.setErrMsg(ex.getMessage());  // 개발에서만 보냄.
    	log.error("EXCEPTION", ex);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
	
	
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
    	log.error("EXCEPTION", ex);
    	StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String strStackTrace = sw.toString(); // 개발에서만 보냄.
        return new ResponseEntity<>(strStackTrace, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<?> handleAuthenticationException(AuthenticationException ex) {
    	log.error("UNAUTHORIZED", ex);
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler(MyException.class)
    public ResponseEntity<?> handleMyException(MyException ex) {
    	log.error("MyException", ex);
    	ResVO res = new ResVO();
    	res.setErrCode(ex.getErrCode());
    	res.setErrMsg(ex.getErrMsg());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    //---------------------------------------------
    // Step 2 - handler로 넘어온 유형확인
    //        - beforeBodyWrite로 넘길것인가? 
    //---------------------------------------------
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return converterType.equals(org.springframework.http.converter.json.MappingJackson2HttpMessageConverter.class);
	}
	
    //---------------------------------------------
    // Step 2 - response body 처리
    //---------------------------------------------
	@Override
	@Nullable
	public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if(body instanceof ResVO) {
			ResVO res = (ResVO)body;
			res.setSuccess(true);
			return res;
		} else {
			return body;
		}		
	}

    //---------------------------------------------

	/*
	
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ResVO> handleAuthenticationException(AuthenticationException ex) {
		ResVO res = new ResVO();
		res.setSuccess(false);
		res.setErrCode("UNKNOWN");
		res.setErrMsg(ex.getMessage());
		log.error("UNAUTHORIZED", ex);
        return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResVO> handleException(Exception ex) {
		ResVO res = new ResVO();
		res.setSuccess(false);
		res.setErrCode("Exception");
		res.setErrMsg(ex.getMessage());
		log.error("Exception", ex);
        return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
    }
    
	
    @ExceptionHandler(MyException.class)
    public MyException jsonException(MyException ex) {
    	return ex;
    }

    @ExceptionHandler(Exception.class)
    public Exception jsonException(Exception ex) {
    	return ex;
    }


	@Override
	@Nullable
	public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if (body instanceof MyException) {
			ResVO res = new ResVO();
			MyException err = (MyException)body;
			res.setSuccess(false);
			res.setErrCode(err.getErrCode());
			res.setErrMsg(err.getErrMsg());
			return res;
//		} else if (body instanceof Exception) {
//			ResVO res = new ResVO();
//			Exception err = (Exception)body;
//			res.setSuccess(false);
//			res.setErrCode("UNKNOWN");
//			res.setErrMsg(err.getMessage());
//			log.error("UNKNOWN", err);
//			return res;
		} else if(body instanceof ResVO) {
			ResVO res = (ResVO)body;
			res.setSuccess(true);
			return res;
		} else {
			return body;
		}
	}	

	*/

}
