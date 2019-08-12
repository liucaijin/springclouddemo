package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.InstanceClient;
import com.xuan.chapter.common.chapter5.dto.Instance;

@Service
public class InstanceService {
	
	@Autowired
	InstanceClient instanceClient;
	
	public Instance getInstanceByServiceIdWithFeign(String serviceId){
		return instanceClient.getInstanceByServiceId(serviceId);
	}
}
