package com.kingsley.consumer.client.impl;

import com.kingsley.consumer.client.UserClient;
import com.kingsley.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author kingsley
 * @time 2022/2/10 18:27
 * @ide IntelliJ IDEA
 * @name com.kingsley.consumer.client.impl.UserClientFallback
 * @desc 用户信息接口熔断方法
 */
@Component
public class UserClientFallback implements UserClient {
    
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setUsername("服务器正忙，请稍后再试！");
        return user;
    }
}
