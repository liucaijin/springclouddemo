package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.config.MySelfRibbonRule;

@RestController
@Configuration
@RibbonClient(name="eureka-client-service",configuration=MySelfRibbonRule.class)
public class AskController {
	
	@Value("${spring.application.name}")
	private String name;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${cloud.version}")
    private String version;
	
	
	@Autowired  
    private LoadBalancerClient loadBalancerClient; 
	
	@RequestMapping(value="/ask")
	public String ask(){
		ServiceInstance choose = this.loadBalancerClient.choose("eureka-client-service");//随机访问策略
		System.out.println("===" + ":" + choose.getServiceId() + ":" + choose.getHost() + ":"
				+ choose.getPort());// 打印当前调用服务的信息
		String hostPort=choose.getHost() + ":"
				+ choose.getPort();
		String body = restTemplate.getForEntity("http://"+hostPort+"/hello/{name}", String.class, name).getBody();
		return body;
	}
	
	@RequestMapping(value="/getversion")
	public String getVersion(){
		return "spring cloud版本:"+ this.version;
	}
}
