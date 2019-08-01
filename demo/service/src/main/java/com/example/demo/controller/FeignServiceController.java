package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuan.chapter.common.chapter5.dto.Instance;

@RestController
@RequestMapping("/feign-service")
public class FeignServiceController {
	
	public Instance getIntanceByServiceId(@PathVariable("serviceId")String serviceId){
		return new Instance();
	}

}
