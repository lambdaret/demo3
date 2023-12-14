package com.example.demo3.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
	public String index() {
    	String a = "222AAA";
    	System.out.println("index한글");
		System.out.println(a);
		return "/index";
	}
}
