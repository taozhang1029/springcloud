package com.kingsley.service;

import com.kingsley.mapper.UserMapper;
import com.kingsley.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Time : 2020/12/3 21:35
 * @Author : Kingsley
 * @Project : Leyou
 * @File : UserService.java
 * @IDE : IntelliJ IDEA
 */
@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    public User queryById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
    
}
