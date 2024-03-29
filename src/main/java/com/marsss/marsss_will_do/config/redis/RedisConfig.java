package com.marsss.marsss_will_do.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder() ;
                sb.append(o.getClass().getName()) ;
                sb.append(method.getName()) ;
                for(Object obj : objects) {
                    sb.append(obj.toString()) ;
                }
                System.out.println("调用Redis缓存key"+sb.toString());
                return sb.toString() ;
            }
        };
    }

    /**
     * 采用RedisCacheManager作为缓存管理器
     * @param connectionFactory
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheManager redisCacheManager = RedisCacheManager.create(connectionFactory) ;
        return redisCacheManager ;
    }

    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory) {
        //解决键值序列化问题
        StringRedisTemplate template = new StringRedisTemplate(factory) ;
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class) ;
        ObjectMapper om = new ObjectMapper() ;
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY) ;
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL) ;
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template ;
    }

}
