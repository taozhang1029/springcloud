package com.kingsley.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author kingsley
 * @time 2022/2/10 20:29
 * @ide IntelliJ IDEA
 * @name com.kingsley.zuul.ZuulStarter
 * @desc Zuul网关启动器
 */
@SpringBootApplication
@EnableZuulProxy // 启用zuul网关代理功能
public class ZuulStarter {
    public static void main(String[] args) {
        SpringApplication.run(ZuulStarter.class, args);
    }
}
