package com.marsss.marsss_will_do.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 添加跨域请求
     * allowCredentials 是否携带jsessionid
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/apis/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowCredentials(true)
                .allowedOrigins("http://localhost:8070") ;
    }
}
