package com.kingsley;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Time : 2020/12/4 12:58
 * @Author : Kingsley
 * @Project : Leyou
 * @File : ConsumerApplication.java
 * @IDE : IntelliJ IDEA
 */

// @SpringBootApplication
// @EnableDiscoveryClient
// @EnableCircuitBreaker // 开启熔断组件

@SpringCloudApplication // 组合注解
@EnableFeignClients // 开启feign
public class ConsumerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class);
    }
}
