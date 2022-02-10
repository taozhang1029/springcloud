package com.kingsley.consumer.client;

import com.kingsley.consumer.client.impl.UserClientFallback;
import com.kingsley.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author kingsley
 * @time 2022/2/10 18:04
 * @ide IntelliJ IDEA
 * @name com.kingsley.consumer.client.UserClient
 * @desc Feign的用户信息访问接口
 */
@FeignClient(value = "service-provider", fallback = UserClientFallback.class) // value值为远程调用的服务的id
public interface UserClient {
    
    /**
     * feign的使用方法与SpringMVC类似，支持使用SpringMVC的注解
     */
    @GetMapping("user/{id}")
    // service-provider/user/{id} 即为远程服务的访问路径
    User queryById(@PathVariable("id") Long id);
    
}
