package com.example.demo3.sample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo3.sample.domain.BoardVO;
import com.example.demo3.sample.entity.Board;
import com.example.demo3.sample.entity.BoardRepository;
import com.example.demo3.sample.repository.BoardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SampleService {
//	@Autowired
	BoardMapper boardMapper;
	
	BoardRepository boardrRepository;
	
	public List<BoardVO> selectBoardList(BoardVO vo) {
		return boardMapper.selectBoardList(vo);
	}
	
	public List<Board> getBoardList(BoardVO vo) {
		return boardrRepository.findAll();
	}
}
