package com.example.demo3.sample.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.sample.domain.BoardVO;
import com.example.demo3.sample.model.Board;
import com.example.demo3.sample.service.SampleJpaService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class SampleJpaController {
	
	SampleJpaService sampleJpaService;
	
	@GetMapping("/sample/jpa/findAllBoard")
	public List<Board> findAllBoard(HttpServletRequest req, BoardVO param) {
		List<Board> list = sampleJpaService.findAllBoard(param);
		return list;
	}
	
	@PostMapping("/sample/jpa/insertBoard")
	public void insertBoard(HttpServletRequest req, @RequestBody BoardVO param) {
		
		sampleJpaService.insertBoard(param);
	}
	
	
}
