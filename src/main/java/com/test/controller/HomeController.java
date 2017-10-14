package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String displayHomePage(){
		System.out.println("\nDisplaying index page trhough controller");
		return "index";
	}
}
