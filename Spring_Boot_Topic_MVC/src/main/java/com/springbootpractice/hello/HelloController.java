package com.springbootpractice.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome page";
	}
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World, Rohit here!!";
	}
}
