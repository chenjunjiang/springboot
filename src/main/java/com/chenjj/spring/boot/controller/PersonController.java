package com.chenjj.spring.boot.controller;

import com.chenjj.spring.boot.model.Person;
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
    @GetMapping("/person")
    public Person getPerson() {
        Person person = new Person();
        person.setId(1);
        person.setName("chenjj");
        person.setAge(18);
        person.setEmail("chenjj@163.com");
        return person;
    }
}
