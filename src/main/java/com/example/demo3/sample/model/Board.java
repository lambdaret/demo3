package com.example.demo3.sample.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Data
//@Table(name = "TB_BOARD")
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long boardSeq;
	
	@Column(length = 200, nullable = false)
	String title;
	
	@Column(columnDefinition = "TEXT", nullable = true)
	String contentText;
	
	@Column(columnDefinition = "BLOB", nullable = true)
	byte [] contentBlob;
	
	
	@Column(nullable = true)
	Integer fInt;
	
	@Column(nullable = true)
	Long fBint;
	
	@Column(nullable = true)
	String fChr;
	
	@Column(nullable = true)
	Float fFloat;
	
	@Column(nullable = true)
	Double fDouble;
	
	@Column(nullable = true)
	Date fDate;
	
	@Column(nullable = true)
	Timestamp fDatetime;
	
	@Column(nullable = true)
	Timestamp fTimestamp;
	
	@Column(nullable = true)
	BigDecimal fDecimal;
}
