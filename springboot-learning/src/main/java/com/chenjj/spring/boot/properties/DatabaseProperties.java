package com.chenjj.spring.boot.properties;

import lombok.Data;

/**
 * @ClassName DatabaseProperties
 * @Description
 * @Author chenjunjiang
 * @Date 18:54 2025/6/18
 * @Version 1.0
 **/
@Data
public class DatabaseProperties {
    private String url;
    private String username;
    private String password;
}
