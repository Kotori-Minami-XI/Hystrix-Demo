package com.Kotori.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    /***
     * 异常降级处理
     * http://127.0.0.1:8001/consumer1?name=wc
     */
    @ResponseBody
    @RequestMapping("/consumer1")
    public String consumer1(String name) {
        return restTemplate.getForObject("http://hystrix-provider-group/provider1?name=" + name, String.class);
    }

    /***
     * 超时降级处理
     * http://127.0.0.1:8001/consumer2?name=ls
     */
    @ResponseBody
    @RequestMapping("/consumer2")
    @HystrixCommand(fallbackMethod = "timeoutFallback")
    public String consumer2(String name) {
        return restTemplate.getForObject("http://hystrix-provider-group/provider2?name=" + name, String.class);
    }
    private String timeoutFallback(String name) {
        System.out.println("-----------------------timeoutFallback");
        return "timeoutFallback";
    }
}
