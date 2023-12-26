package com.example.demo3.sample.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo3.sample.domain.BoardVO;
import com.example.demo3.sample.domain.Paging;
import com.example.demo3.sample.repository.BoardMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SampleMybatisService {
	BoardMapper boardMapper;
	
	public List<BoardVO> selectBoardList(BoardVO vo) {
		return boardMapper.selectBoardList(vo);
	}
	
	public Page<BoardVO> selectBoardPaging(BoardVO vo) {
		Paging paging = vo.getPaging();
		PageHelper.startPage(paging.getPageNo(), paging.getPageSize());
		return (Page<BoardVO>)boardMapper.selectBoardList(vo);
	}
	
	@Transactional
	public void insertBoard(BoardVO vo) {
		boardMapper.insertBoard(vo);
		/*
		if(true) {
			throw new RuntimeException("test");
		}
		*/
		boardMapper.insertBoard(vo);
	}
	
}
