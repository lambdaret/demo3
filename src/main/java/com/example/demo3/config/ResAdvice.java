package com.example.demo3.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.example.demo3.common.domain.MyException;
import com.example.demo3.common.domain.ResVO;

@RestControllerAdvice
public class ResAdvice implements ResponseBodyAdvice<Object> {

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
		ResVO<Object> res = new ResVO<>();
		if (body instanceof MyException) {
			MyException err = (MyException)body;
			res.setSuccess(false);
			res.setErrCode(err.getErrCode());
			res.setErrMsg(err.getErrMsg());
			return res;
		} else if (body instanceof Exception) {
			Exception err = (Exception)body;
			res.setSuccess(false);
			res.setErrCode("UNKNOWN");
			res.setErrMsg(err.getMessage());
			return res;
		} else {
			res.setSuccess(true);
			res.setData(body);
			return res;
			
		}
	}	



}
