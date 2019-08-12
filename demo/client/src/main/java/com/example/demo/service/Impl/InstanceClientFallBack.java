package com.example.demo.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.service.InstanceClient;
import com.xuan.chapter.common.chapter5.dto.Instance;

@Component
public class InstanceClientFallBack implements InstanceClient{
	
	final static Logger logger = LoggerFactory.getLogger(InstanceClientFallBack.class);

	@Override
	public Instance getInstanceByServiceId(String serviceId) {
		logger.info("Can not get Instance by serviceId {}",serviceId);
		return new Instance("error","error",0);
	}
	
	
}
