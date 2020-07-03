package com.Kotori;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient // 开启EurekaClient功能
@EnableCircuitBreaker
public class HystrixConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixConsumerApplication.class);
    }
}
