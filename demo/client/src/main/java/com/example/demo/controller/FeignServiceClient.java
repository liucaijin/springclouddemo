package com.example.demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xuan.chapter.common.chapter5.dto.Instance;

@FeignClient("eureka-client-service")
@RequestMapping("/feign-service")
public interface FeignServiceClient {
	
	@RequestMapping(value="/instance/{serviceId}",method=RequestMethod.GET)
	public Instance getInstanceByServiceId(@PathVariable("serviceId")String serviceId);
	
	@RequestMapping(value="/instance/exception",method=RequestMethod.GET)
	public Integer getException();
}
