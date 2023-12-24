package com.example.demo3.sample.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.common.domain.ResVO;
import com.example.demo3.sample.domain.BoardVO;
import com.example.demo3.sample.service.SampleService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class SampleController {
//	private final Logger logger = LogManager.getLogger(SampleController.class);

	SampleService sampleService;
	private final PasswordEncoder passwordEncoder;
	
	@PostMapping("/sample/insertBoard")
	public ResVO insertBoard(HttpServletRequest req, @RequestBody BoardVO param) {
		log.info("insertBoard");
		sampleService.insertBoard(param);
		ResVO res = new ResVO();
		return res;
	}
	
	@GetMapping("/sample/encPwd")
	public ResVO endPwd(HttpServletRequest req) {
		log.info("endPwd");
		String password = passwordEncoder.encode("1");
		ResVO res = new ResVO();
		res.setData(password);
		return res;
	}
	
}
