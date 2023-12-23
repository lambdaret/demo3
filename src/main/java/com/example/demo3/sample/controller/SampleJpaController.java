package com.example.demo3.sample.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.common.domain.ResVO;
import com.example.demo3.sample.domain.BoardVO;
import com.example.demo3.sample.model.Board;
import com.example.demo3.sample.service.SampleJpaService;
import com.example.demo3.sample.service.SampleService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@Tag(name = "SampleJpaController", description = "SampleJpaController API")
public class SampleJpaController {
	private final Logger logger = LogManager.getLogger(SampleJpaController.class);
	SampleJpaService sampleJpaService;

	
	@GetMapping("/sample/jpa/findAllBoard")
	public ResVO findAllBoard(HttpServletRequest req, BoardVO param) {
		logger.info("findAllBoard");
		List<Board> list = sampleJpaService.findAllBoard(param);
		return new ResVO(list);
	}
	
	@PostMapping("/sample/jpa/insertBoard")
	public ResVO insertJpaBoard(HttpServletRequest req, @RequestBody BoardVO param) {
		logger.info("insertBoard");
		sampleJpaService.insertBoard(param);
		ResVO res = new ResVO();
		return res;
	}
	


	
}
