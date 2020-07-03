package com.Kotori.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @ResponseBody
    @RequestMapping("/provider0")
    @HystrixCommand(fallbackMethod = "globalFallback")
    public String provider0(String name) {
        return name + ", Welcome to Spring Boot. I am provider2";
    }
    private String globalFallback(String name) {
        System.out.println("-----------------------globalFallback");
        return "globalFallback";
    }

    @ResponseBody
    @RequestMapping("/provider1")
    @HystrixCommand(fallbackMethod = "exceptionFallback")
    public String provider1(String name) {
        int i = 1/0;
        return name + ", Welcome to Spring Boot. I am provider1";
    }
    private String exceptionFallback(String name) {
        System.out.println("-----------------------exceptionFallback");
        return "exceptionFallback";
    }

    @ResponseBody
    @RequestMapping("/provider2")
    public String provider2(String name) throws InterruptedException {
        Thread.sleep(3000);
        return name + ", Welcome to Spring Boot. I am provider2";
    }

}