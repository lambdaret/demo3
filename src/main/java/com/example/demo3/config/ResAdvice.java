package com.example.demo3.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.example.demo3.common.domain.MyException;
import com.example.demo3.common.domain.ResVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ResAdvice implements ResponseBodyAdvice<Object> {
//	private final Logger logger = LogManager.getLogger(SampleController.class);
	
	/*
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ResVO> handleException(AuthenticationException ex) {
		ResVO res = new ResVO();
		
		res.setSuccess(false);
		res.setErrCode("UNKNOWN");
		res.setErrMsg(ex.getMessage());
		logger.error("UNAUTHORIZED", ex);
    	
        return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
    }
    */
	
    @ExceptionHandler(MyException.class)
    public MyException jsonException(MyException ex) {
    	return ex;
    }

    @ExceptionHandler(Exception.class)
    public Exception jsonException(Exception ex) {
    	return ex;
    }

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
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
		} else if (body instanceof Exception) {
			ResVO res = new ResVO();
			Exception err = (Exception)body;
			res.setSuccess(false);
			res.setErrCode("UNKNOWN");
			res.setErrMsg(err.getMessage());
			log.error("UNKNOWN", err);
			return res;
		} else if(body instanceof ResVO) {
			ResVO res = (ResVO)body;
			res.setSuccess(true);
			return res;
		} else {
			return body;
		}
	}	



}
