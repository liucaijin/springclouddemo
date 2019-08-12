package com.example.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.Impl.InstanceClientFallBack;
import com.xuan.chapter.common.chapter5.dto.Instance;

@FeignClient(name="eureka-client-service",fallback=InstanceClientFallBack.class,qualifier="InstanceClient")
public interface InstanceClient {

	@RequestMapping(value= "/feign-service/instance/{serviceId}",method=RequestMethod.GET)
	public Instance getInstanceByServiceId(@PathVariable("serviceId")String serviceId);
}
