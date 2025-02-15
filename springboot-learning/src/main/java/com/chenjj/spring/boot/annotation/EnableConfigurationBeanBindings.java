package com.chenjj.spring.boot.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ConfigurationBeanBindingsRegister.class)
public @interface EnableConfigurationBeanBindings {
    String[] value();
}
