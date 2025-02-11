package com.chenjj.spring.boot.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * @ClassName Person
 * @Description
 * @Author chenjunjiang
 * @Date 20:53 2025/2/10
 * @Version 1.0
 **/
@Data
public class Person {
    private long id;
    private String name;
    private String email;
    private int age;
}
