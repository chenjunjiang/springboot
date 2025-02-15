package com.chenjj.spring.boot.service;

import com.chenjj.spring.boot.event.GetPersonEvent;
import com.chenjj.spring.boot.model.Person;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName PointsService
 * @Description
 * @Author chenjunjiang
 * @Date 21:25 2025/2/13
 * @Version 1.0
 **/
@Service
public class PointsService {
    @EventListener
    public void add(GetPersonEvent event) {
        Person person = (Person) event.getSource();
        System.out.println("收到了 " + event.getClass().getName() + "事件，开始给" + person.getName() + "增加积分======");
    }
}
