package com.example.demo3.sample.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.sample.domain.BoardVO;
import com.example.demo3.sample.service.SampleMybatisService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class SampleMybatisController {
	
	SampleMybatisService sampleMybatisService;
	
	@GetMapping("/sample/mybatis/selectBoardList")
	public List<BoardVO> selectBoardList(HttpServletRequest req, BoardVO param) {
//		if(true)
//			throw new MyException("0001", "error");
//		if(true) {
//			int i = 1/0;
//			System.out.println(String.format("%d", i));
//		}
		return sampleMybatisService.selectBoardList(param);
	}
	
	@PostMapping("/sample/mybatis/insertBoard")
	public void insertBoard(HttpServletRequest req, @RequestBody BoardVO param) {
		
		sampleMybatisService.insertBoard(param);
	}
	
	@GetMapping("/board")
    public BoardVO getBoard() {
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardSeq(1L);
        boardVO.setTitle("한글");
        
        return boardVO;
    }
	
}
