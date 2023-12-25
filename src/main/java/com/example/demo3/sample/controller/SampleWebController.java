package com.example.demo3.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SampleWebController {
	@GetMapping("/sample/test2")
	public String test2(HttpServletRequest req) {
//		if(true) {
//			throw new RuntimeException("error");
//		}
		return "sample";
	}

}
