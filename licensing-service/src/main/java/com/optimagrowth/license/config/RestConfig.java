package com.optimagrowth.license.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplateCustom(RestTemplateBuilder builder){
        return builder
                .additionalInterceptors((request, body, execution) -> {
                    System.out.println("Resolved URL: " + request.getURI()); // shows final resolved URI
                    return execution.execute(request, body);
                })
                .build();
    }
}
