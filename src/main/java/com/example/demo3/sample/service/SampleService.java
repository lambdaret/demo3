package com.example.demo3.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo3.sample.domain.BoardVO;
import com.example.demo3.sample.repository.BoardMapper;

@Service
public class SampleService {
	@Autowired
	BoardMapper boardMapper;
	
	public List<BoardVO> selectBoardList(BoardVO vo) {
		return boardMapper.selectBoardList(vo);
	}
}
