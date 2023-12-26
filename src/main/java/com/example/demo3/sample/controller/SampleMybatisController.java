package com.example.demo3.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.common.domain.ResVO;
import com.example.demo3.sample.domain.BoardVO;
import com.example.demo3.sample.domain.Paging;
import com.example.demo3.sample.service.SampleMybatisService;
import com.github.pagehelper.PageInfo;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class SampleMybatisController {
	
	SampleMybatisService sampleMybatisService;
	
	@GetMapping("/sample/mybatis/selectBoardList")
	public List<BoardVO> selectBoardList(HttpServletRequest req, @RequestBody BoardVO param) {
//		if(true)
//			throw new MyException("0001", "error");
//		if(true) {
//			int i = 1/0;
//			System.out.println(String.format("%d", i));
//		}
		return sampleMybatisService.selectBoardList(param);
	}

	@GetMapping("/sample/mybatis/selectBoardPaging")
	public ResVO selectBoardPaging(HttpServletRequest req, @RequestBody BoardVO param) {
		PageInfo<BoardVO> pageInfo = new PageInfo<BoardVO>(sampleMybatisService.selectBoardPaging(param));
		
		List<BoardVO> list = pageInfo.getList();
		
		Paging paging = new Paging();
		paging.setPageNo(pageInfo.getPageNum());
		paging.setPageSize(pageInfo.getPageSize());
		paging.setTotalCount(pageInfo.getTotal());
		
		Map<String, Object> data = new HashMap<>();
		data.put("list", list);
		data.put("paging", paging);
		return new ResVO(data);

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
