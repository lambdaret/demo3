package com.example.demo3.common.domain;

import lombok.Data;

@Data
public class ResVO {
	boolean success;
	String errCode;
	String errMsg;
	Object data;
	
	public ResVO(Object data) {
		this.data = data;
	}

	public ResVO() {
	}
}
