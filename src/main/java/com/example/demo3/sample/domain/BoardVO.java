package com.example.demo3.sample.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	Long boardSeq;
	String title;
	String contentText;
	byte [] contentBlob;
	Integer fInt;
	Long fBint;
	String fChr;
	Float fFloat;
	Double fDouble;
	Date fDate;
	Timestamp fDatetime;
	Timestamp fTimestamp;
	BigDecimal fDecimal;
	
	Paging paging; // = new Paging();
}
