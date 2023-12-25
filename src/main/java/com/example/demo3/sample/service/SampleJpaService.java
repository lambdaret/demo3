package com.example.demo3.sample.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo3.sample.domain.BoardVO;
import com.example.demo3.sample.domain.Paging;
import com.example.demo3.sample.model.Board;
import com.example.demo3.sample.repository.BoardRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SampleJpaService {
	BoardRepository boardRepository;

	public List<Board> findAllBoard(BoardVO vo) {
		return boardRepository.findAll();
	}

	public Page<Board> findAllBoardPaging(BoardVO vo) {
		Paging paging = vo.getPaging();
		PageRequest pageRequest = PageRequest.of(paging.getPageNo(), paging.getPageSize());
		return boardRepository.findAll(pageRequest);
	}
	
	@Transactional
	public void insertBoard(BoardVO vo) {
		Board board1 = new Board();
		board1.setTitle(vo.getTitle());
		board1.setContentText(vo.getContentText());

		Board board2 = new Board();
		board2.setTitle(vo.getTitle());
		board2.setContentText(vo.getContentText());
		
		boardRepository.save(board1);
		//if(true) {
		//	throw new RuntimeException("");
		//}
		boardRepository.save(board2);
	}

}
