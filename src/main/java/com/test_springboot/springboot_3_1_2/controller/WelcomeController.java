package com.test_springboot.springboot_3_1_2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WelcomeController {
	@GetMapping //стартовая страница приветствия
	public String printWelcome() {
		return "index";
	}

}