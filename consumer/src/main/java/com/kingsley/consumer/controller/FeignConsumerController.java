package com.kingsley.consumer.controller;

import com.kingsley.consumer.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kingsley
 * @time 2022/2/10 18:00
 * @ide IntelliJ IDEA
 * @name com.kingsley.consumer.controller.FeignConsumerController
 * @desc Feign测试接口
 */
@Controller
@RequestMapping("/feign/user")
public class FeignConsumerController {
    
    @Autowired
    private UserClient userClient;
    
    @GetMapping("{id}")
    @ResponseBody
    public String queryById(@PathVariable("id") Long id) {
        return userClient.queryById(id).toString();
    }
    
    
}
