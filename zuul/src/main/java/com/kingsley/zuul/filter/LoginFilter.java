package com.kingsley.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kingsley
 * @time 2022/2/10 21:49
 * @ide IntelliJ IDEA
 * @name com.kingsley.zuul.filter.LoginFilter
 * @desc 自定义过滤器
 */
@Component
public class LoginFilter extends ZuulFilter {
    
    /**
     * 指定过滤器的类型（在哪个生命周期执行）pre route post error
     */
    @Override
    public String filterType() {
        return "pre";
    }
    
    /**
     * 执行优先级，返回值越小，优先级越高
     */
    @Override
    public int filterOrder() {
        return 10;
    }
    
    /**
     * 是否执行run方法 true：是，false：否
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    
    /**
     * 执行拦截的业务逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // zuul网关的上下文对象
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 获取请求对象
        HttpServletRequest request = currentContext.getRequest();
    
        String remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (StringUtils.isBlank(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        System.out.println("remoteAddr = " + remoteAddr);
        
        // 获取请求参数里的token
        String token = request.getParameter("token");
        // 如果为空，表示未登录，进行拦截
        if (StringUtils.isBlank(token)) {
            // 不转发请求
            currentContext.setSendZuulResponse(false);
            // 设置响应状态码
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            // 设置响应信息
            // 解决浏览器页面请求及结果中文乱码问题
            currentContext.getResponse().setContentType("text/html;charset=UTF-8");
            currentContext.setResponseBody("请登录！");
        }
        // 返回null表示什么都不干
        return null;
    }
}
