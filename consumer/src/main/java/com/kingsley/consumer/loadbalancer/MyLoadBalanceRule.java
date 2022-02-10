package com.kingsley.consumer.loadbalancer;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author kingsley
 * @time 2022/2/10 16:10
 * @ide IntelliJ IDEA
 * @name com.kingsley.consumer.loadbalance.MyLoadBalanceRule
 * @desc 自定义负载均衡器
 */
@Slf4j
public class MyLoadBalanceRule extends AbstractLoadBalancerRule {
    
    @Override
    public Server choose(Object key) {
        ILoadBalancer loadBalancer = this.getLoadBalancer();
        List<Server> allServers = loadBalancer.getAllServers();
        if (CollectionUtils.isEmpty(allServers)) {
            return null;
        }
        log.info("key: {}", key);
        log.info("servers: {}", allServers);
        return allServers.get(0);
    }
    
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    
    }
}
