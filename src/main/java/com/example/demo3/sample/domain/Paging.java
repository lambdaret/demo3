package com.example.demo3.sample.domain;



import lombok.Data;

@Data
public class Paging {
	int pageNo = 1;
	int pageSize = 10;
	long totalCount = 0;
}
