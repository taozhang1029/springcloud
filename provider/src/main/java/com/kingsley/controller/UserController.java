package com.kingsley.controller;

import com.kingsley.pojo.User;
import com.kingsley.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Time : 2020/12/3 21:38
 * @Author : Kingsley
 * @Project : Leyou
 * @File : UserController.java
 * @IDE : IntelliJ IDEA
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        User user = userService.queryById(id);
        log.info("queryById method ... {}", user);
        return user;
    }
}
