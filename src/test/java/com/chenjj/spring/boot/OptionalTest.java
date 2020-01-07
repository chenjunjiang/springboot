package com.chenjj.spring.boot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chenjj.spring.boot.model.User;

import java.util.Optional;

/**
 * @author chenjj
 * @description TODO
 * @creat_time 2020/1/6
 **/
public class OptionalTest {
    public static void main(String[] args) {
        String str = "test";
        String result = Optional.ofNullable(str).map(t -> {
            System.out.println("执行map......");
            return "有值";
        }).get();
        System.out.println(result);

        User user = new User();
        user.setId(11L);
        user.setPassword("xxx");
        user.setUsername("lisi");
        // 字符串序列化之后还是字符串
        //String r = JSON.toJSONString("zhangsan", SerializerFeature.WriteClassName);
        // 加上SerializerFeature.WriteClassName之后结果会多出type
        // {"@type":"com.chenjj.spring.boot.model.User","id":11,"password":"xxx","username":"lisi"}
        String r = JSON.toJSONString(user, SerializerFeature.WriteClassName);
        System.out.println(r);
    }
}
