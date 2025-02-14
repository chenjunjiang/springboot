package com.chenjj.spring.boot.controller;

import com.chenjj.spring.boot.event.EventPublisher;
import com.chenjj.spring.boot.event.GetPersonEvent;
import com.chenjj.spring.boot.model.Person;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PersonController
 * @Description
 * @Author chenjunjiang
 * @Date 21:08 2025/2/10
 * @Version 1.0
 **/
@RestController
public class PersonController {

    @Resource
    private  EventPublisher eventPublisher;
    /**
    * @Description: 模拟获取到Person后调用账户服务减钱、调用优惠券服务发优惠券、调用积分服务新增积分
    * @Param:
    * @return: com.chenjj.spring.boot.model.Person
    * @Author: chenjunjiang
    * @Date: 21:18 2025/2/13
    */
    @GetMapping("/person")
    public Person getPerson() {
        Person person = new Person();
        person.setId(1);
        person.setName("chenjj");
        person.setAge(18);
        person.setEmail("chenjj@163.com");

        /**
         * 传统实现方式是，注入账户服务、优惠券服务、积分服务，然后挨个调用对应的方法
         */

        // 现在使用事件驱动实现，这样所有服务只需要监听GetPersonEvent事件，然后实现对应的逻辑
        // 对新增开放，对修改关闭的模式
        eventPublisher.publishEvent(new GetPersonEvent(person));

        return person;
    }

}
