package com.chenjj.spring.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by chenjunjiang on 18-10-4.
 * 做测试的时候需要有Application这个类，以便加载所有需要的资源
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    private static final Logger log = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Autowired
    @Qualifier("redisTest1Script")
    private DefaultRedisScript<List> redisTest1Script;

    @Autowired
    @Qualifier("redisTest2Script")
    private DefaultRedisScript<Boolean> redisTest2Script;

    @Test
    public void test() {
        /*ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 1000).forEach(i -> executorService.execute(() -> stringRedisTemplate.opsForValue()
        .increment("kk", 1)));
        String kk = stringRedisTemplate.opsForValue().get("kk");
        System.out.println(kk);*/
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("k1", "test", 100, TimeUnit.SECONDS);
    }

    @Test
    public void testLua1() {
        List<String> keys = new ArrayList<>(2);
        keys.add("count");
        keys.add("rate.limiting:127.0.0.1");
        Map<String, Object> args = new HashMap<>(2);
        args.put("expire", 10000);
        args.put("times", 10);
        List result = redisCacheTemplate.execute(redisTest1Script, keys, args);
        System.out.println(result);
        // 返回结果是List
        // [{"count":"10","ttl":10000,"rate.limiting:127.0.0.1":"1"}, {times=10, expire=10000}]
    }

    /**
     * 特别注意:最好是不要在lua文件中出现中文注释,某些中文会导致以下错误:
     * org.springframework.data.redis.RedisSystemException: Error in execution;
     * nested exception is io.lettuce.core.RedisCommandExecutionException:
     * ERR Error compiling script (new function): user_script:8: malformed number near '0key1'
     */
    @Test
    public void testLua2() {
        List<String> keys = new ArrayList<>(1);
        keys.add("testLua2");
        boolean result = stringRedisTemplate.execute(redisTest2Script, keys, "zhangsan", "600");
        System.out.println(result);
    }

}
