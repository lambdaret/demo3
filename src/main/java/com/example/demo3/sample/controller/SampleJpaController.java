package com.example.demo3.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.common.domain.ResVO;
import com.example.demo3.sample.domain.BoardVO;
import com.example.demo3.sample.domain.Paging;
import com.example.demo3.sample.model.Board;
import com.example.demo3.sample.service.SampleJpaService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@Tag(name = "SampleJpaController", description = "SampleJpaController API")
public class SampleJpaController {
//	private final Logger logger = LogManager.getLogger(SampleJpaController.class);
	SampleJpaService sampleJpaService;

	
	@GetMapping("/sample/jpa/findAllBoard")
	public ResVO findAllBoard(HttpServletRequest req, BoardVO param) {
		log.info("findAllBoard");
		List<Board> list = sampleJpaService.findAllBoard(param);
		return new ResVO(list);
	}

	@GetMapping("/sample/jpa/findAllBoardPaging")
	public ResVO findAllBoardPaging(HttpServletRequest req, @RequestBody BoardVO param/*, @Param("paging") Paging pageing*/) {
		log.info("findAllBoardPaging");
		Page<Board> listPaging = sampleJpaService.findAllBoardPaging(param);
		List<Board> list = listPaging.getContent();

		Paging paging = new Paging();
		paging.setPageNo(listPaging.getNumber());
		paging.setPageSize(listPaging.getSize());
		paging.setTotalCount(listPaging.getTotalElements());
		
		Map<String, Object> data = new HashMap<>();
		data.put("list", list);
		data.put("paging", paging);
		return new ResVO(data);
	}

	
	
	@PostMapping("/sample/jpa/insertBoard")
	public ResVO insertJpaBoard(HttpServletRequest req, @RequestBody BoardVO param) {
		log.info("insertBoard");
		sampleJpaService.insertBoard(param);
		ResVO res = new ResVO();
		return res;
	}
	


	
}
