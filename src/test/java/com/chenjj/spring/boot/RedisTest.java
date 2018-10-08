package com.chenjj.spring.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by chenjunjiang on 18-10-4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    private static final Logger log = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 1000).forEach(i -> executorService.execute(() -> stringRedisTemplate.opsForValue()
                .increment("kk", 1)));
        String kk = stringRedisTemplate.opsForValue().get("kk");
        System.out.println(kk);
    }
}
