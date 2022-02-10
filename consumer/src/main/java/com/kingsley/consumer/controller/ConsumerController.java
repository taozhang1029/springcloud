package com.kingsley.consumer.controller;

import com.kingsley.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Time : 2020/12/4 13:03
 * @Author : Kingsley
 * @Project : Leyou
 * @File : ConsumerController.java
 * @IDE : IntelliJ IDEA
 */
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    /*@Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        // 根据服务id获取服务
        List<ServiceInstance> userServices = discoveryClient.getInstances("user-service");
        System.out.println(userServices);
        String url = userServices.get(0).getUri().toString() + "/user/" + id;
        System.out.println(url);
        return restTemplate.getForObject(url, User.class);
    }*/

    /*
    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        String url = "http://user-service/user/" + id;
        return restTemplate.getForObject(url,User.class);
    }*/

    @GetMapping("{id}")
    //@HystrixCommand(fallbackMethod = "queryByIdFallback")
    // 局部自定义超时时长，全局需要在application.yml文件中配置
    /*@HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2500")})*/
    public User queryById(@PathVariable("id") Long id) {

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String url = "http://user-provider/user/" + id;
        return restTemplate.getForObject(url, User.class);
    }

    /*public String queryByIdFallback(Long id) {
        return "抱歉，服务器正忙！";
    }*/

    public String defaultFallback() {
        return "抱歉，服务器正忙！";
    }
}