package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xuan.chapter.common.chapter5.dto.Instance;

@RestController
@RequestMapping("/feign-service")
public class FeignServiceController {
	
	@RequestMapping(value="/instance/{serviceId}",method=RequestMethod.GET)
	public Instance getIntanceByServiceId(@PathVariable("serviceId")String serviceId){
		return new Instance(serviceId);
	}
	
	@RequestMapping(value="/instance/exception",method=RequestMethod.GET)
	public Integer exception(){
		return 3/0;
	}

}
