package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SayHelloController {
	
 
	
	@RequestMapping(value = "/hello/{name}")
	public String sayHello(@PathVariable("name")String name){
		return "Hello2, ".concat(name).concat("!");
	}
}
