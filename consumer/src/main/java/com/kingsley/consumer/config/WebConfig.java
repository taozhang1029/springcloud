package com.kingsley.consumer.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author kingsley
 * @time 2022/2/10 13:06
 * @ide IntelliJ IDEA
 * @name com.kingsley.consumer.config.WebConfig
 * @desc web应用配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * FastJson 配置，可解决 @JsonField 注解无效的bug
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.removeIf(converter -> converter instanceof MappingJackson2HttpMessageConverter);
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        converters.add(fastConverter);
    }
}
