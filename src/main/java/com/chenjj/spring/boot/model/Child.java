package com.chenjj.spring.boot.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName Child
 * @Description
 * @Author chenjunjiang
 * @Date 13:09 2025/2/8
 * @Version 1.0
 **/
@Data
public class Child {
    private String name;
    private int age;
    private Date birthday;
    private List<String> text;
}
