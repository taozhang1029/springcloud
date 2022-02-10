package com.kingsley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description
 * @Time : 2020/12/4 13:27
 * @Author : Kingsley
 * @Project : Leyou
 * @File : EurekaServer.java
 * @IDE : IntelliJ IDEA
 */

@EnableEurekaServer // 启用Eureka
@SpringBootApplication
public class EurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class);
    }
}
