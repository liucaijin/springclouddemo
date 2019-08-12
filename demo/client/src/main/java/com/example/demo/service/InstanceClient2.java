package com.example.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;

import com.example.demo.service.Impl.InstanceClientFallBack;

/**
 * https://github.com/spring-cloud/spring-cloud-netflix/issues/1139 关于http://eureka-client-service的问题
 * @author liucaijin
 *
 */
@FeignClient(name="http://eureka-client-service",fallback=InstanceClientFallBack.class,qualifier="InstanceClient2")
public interface InstanceClient2 {

}
