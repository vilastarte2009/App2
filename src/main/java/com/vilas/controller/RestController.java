package com.vilas.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController
{
	@GetMapping("/get")
	public String home()
	{
		
		return "Hello from Rest Controller";
	}
	
}
