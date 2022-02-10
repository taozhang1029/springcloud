package com.kingsley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description
 * @Time : 2020/12/3 21:26
 * @Author : Kingsley
 * @Project : Leyou
 * @File : UserApplication.java
 * @IDE : IntelliJ IDEA
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.kingsley.mapper")
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class);
    }

}
