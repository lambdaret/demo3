package com.example.demo3.sample.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo3.sample.domain.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> selectBoardList(BoardVO vo);
}
