package com.example.demo3.common.domain;

import lombok.Data;

@Data
public class ResVO<T> {
	boolean success;
	String errCode;
	String errMsg;
	T data;
}
