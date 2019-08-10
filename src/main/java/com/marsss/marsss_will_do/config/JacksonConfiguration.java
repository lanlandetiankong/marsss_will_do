package com.marsss.marsss_will_do.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.List;

/**
 * 解决
 * 1：返回的bean有设置为 lazy 的entity，返回给前端会抛异常的错误
 */
@Configuration
public class JacksonConfiguration  extends WebMvcConfigurerAdapter{
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonMessageConverter());
        super.configureMessageConverters(converters);
    }

    private MappingJackson2HttpMessageConverter jacksonMessageConverter() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Hibernate4Module());
        messageConverter.setObjectMapper(mapper);
        return messageConverter;
    }
}
