package com.chenjj.spring.boot.configuration;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chenjunjiang on 18-10-4.
 */
//@Configuration
public class RedisCacheAutoConfiguration {
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Serializable> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        //template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setValueSerializer(new FastJsonRedisSerializer<>(Serializable.class));
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /**
     * DefaultRedisScript 类来加载脚本的，并设置相应的数据类型来接收lua脚本返回的数据，
     * 这个泛型类在使用时设置泛型是什么类型，脚本返回的结果就是用什么类型接收。
     * <p>
     * The script result type. Should be one of Long, Boolean, List, or deserialized value type.
     * Can be null if the script returns a throw-away status (i.e "OK")
     *
     * @return
     */
    @Bean(name = "redisTest1Script")
    public DefaultRedisScript<List> redisTest1Script() {
        DefaultRedisScript<List> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/test2.lua")));
        redisScript.setResultType(List.class);
        return redisScript;
    }

    @Bean(name = "redisTest2Script")
    public DefaultRedisScript<Boolean> redisTest2Script() {
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/test2.lua")));
        redisScript.setResultType(Boolean.class);
        return redisScript;
    }
}
