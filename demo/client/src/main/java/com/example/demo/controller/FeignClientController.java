package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xuan.chapter.common.chapter5.dto.Instance;

//@RestController
//@RequestMapping("/feign-client")
public class FeignClientController {

    @Autowired
    FeignServiceClient feignServiceClient;

    @RequestMapping(value = "/instance/{serviceId}", method = RequestMethod.GET)
    public Instance getInstanceByServiceId(@PathVariable("serviceId") String serviceId) {
        return feignServiceClient.getInstanceByServiceId(serviceId);
    }
    
    @RequestMapping(value = "/instance/testError", method = RequestMethod.GET)
    public String getInstanceByServiceId() {
    	int i = 2/0;
        return null;
    }
    
    @RequestMapping(value = "/instance/getException", method = RequestMethod.GET)
    public Integer getInvokeError() {
    	return feignServiceClient.getException();
    }

//    @RequestMapping(value = "/instance/{serviceId}", method = RequestMethod.DELETE)
//    public String deleteInstanceByServiceId(@PathVariable("serviceId") String serviceId) {
//        return feignServiceClient.deleteInstanceByServiceId(serviceId);
//    }
//
//    @RequestMapping(value = "/instance", method = RequestMethod.POST)
//    public String createInstance(@RequestBody Instance instance) {
//        return feignServiceClient.createInstance(instance);
//    }
//
//    @RequestMapping(value = "/instance/{serviceId}", method = RequestMethod.PUT)
//    public String updateInstanceByServiceId(@RequestBody Instance instance, @PathVariable("serviceId") String serviceId) {
//        return feignServiceClient.updateInstanceByServiceId(instance, serviceId);
//    }

}