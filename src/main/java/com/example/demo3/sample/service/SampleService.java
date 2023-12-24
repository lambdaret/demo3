package com.example.demo3.sample.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo3.sample.domain.BoardVO;
import com.example.demo3.sample.model.Board;
import com.example.demo3.sample.repository.BoardMapper;
import com.example.demo3.sample.repository.BoardRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SampleService {
	BoardRepository boardRepository;
	BoardMapper boardMapper;
	
	// jpa와 mybatis를 같이 사용해도되나?
	@Transactional
	public void insertBoard(BoardVO vo) {
		Board board1 = new Board();
		board1.setTitle(vo.getTitle() + "-1");
		board1.setContentText(vo.getContentText());

		BoardVO board2 = new BoardVO();
		board2.setTitle(vo.getTitle() + "-2");
		board2.setContentText(vo.getContentText());
		
		
		boardRepository.save(board1);
//		if(true) {
//			throw new RuntimeException("");
//		}
		boardMapper.insertBoard(board2);
//		if(true) {
//			throw new RuntimeException("");
//		}
//		boardRepository.save(board1);
	}	
}
