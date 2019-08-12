package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Impl.InstanceService;
import com.xuan.chapter.common.chapter5.dto.Instance;

@RestController
public class InstanceController {
	
	private final static Logger logger = LoggerFactory.getLogger(InstanceController.class);
	
	@Autowired
	InstanceService instanceService;
	
	@RequestMapping(value="feign/{serviceId}",method=RequestMethod.GET)
	public Instance getInstanceByServiceIdWithFeign(@PathVariable("serviceId")String serviceId){
		logger.info("invoke getInstanceByServiceIdWithFeign serviceId:{}",serviceId);
		return instanceService.getInstanceByServiceIdWithFeign(serviceId);
	}
}
