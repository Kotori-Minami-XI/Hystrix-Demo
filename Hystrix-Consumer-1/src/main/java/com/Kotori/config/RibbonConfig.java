package com.Kotori.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {
    @LoadBalanced
    @Bean
    public RestTemplate rest() {
//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//        requestFactory.setConnectTimeout(9000);
//        requestFactory.setReadTimeout(9000);
//        return new RestTemplate(requestFactory);
        return new RestTemplate();
    }

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
