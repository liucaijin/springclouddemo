package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xuan.chapter.common.chapter5.dto.Instance;

//@FeignClient(name="eureka-client-service",qualifier="InstanceClient")
public interface InstanceClient3 {

	@RequestMapping(value= "/feign-service/instance/exception",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="")
	public Instance getInstanceByServiceId();
	
	default Instance getInstanceFallback(){
		return  new Instance("error222");
	}
}
