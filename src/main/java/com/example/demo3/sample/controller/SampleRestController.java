package com.example.demo3.sample.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.sample.domain.BoardVO;
import com.example.demo3.sample.entity.Board;
import com.example.demo3.sample.service.SampleService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class SampleRestController {
	
	SampleService sampleService;
	
	@GetMapping("/sample/selectBoardList")
	public List<BoardVO> selectBoardList(HttpServletRequest req, BoardVO param) {
//		if(true)
//			throw new MyException("0001", "error");
//		if(true) {
//			int i = 1/0;
//			System.out.println(String.format("%d", i));
//		}
		
		return sampleService.selectBoardList(param);
	}
	
	@GetMapping("/sample/getBoardList")
	public List<Board> getBoardList(HttpServletRequest req, BoardVO param) {
		
		List<Board> list = sampleService.getBoardList(param);
		return list;
	}	
	
	
	@GetMapping("/board")
    public BoardVO getBoard() {
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardSeq(1L);
        boardVO.setTitle("한글");
        
        return boardVO;
    }
	
}
