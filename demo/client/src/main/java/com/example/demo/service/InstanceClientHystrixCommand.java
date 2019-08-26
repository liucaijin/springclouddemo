package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.Impl.InstanceClientFallBack;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xuan.chapter.common.chapter5.dto.Instance;

@Service
public class InstanceClientHystrixCommand {
	
	@Autowired
	RestTemplate restTemplate;
    
	@HystrixCommand(fallbackMethod="getInstanceByServiceIdGetFail")
	public Instance getInstanceByServiceId(String serviceId){
		return restTemplate.getForEntity("http://feign-server/instance/{serviceId}", Instance.class, serviceId).getBody();
	}
	
	public Instance getInstanceByServiceIdGetFail(String serviceId){
		return new Instance("error", "", 0);
	}
}
