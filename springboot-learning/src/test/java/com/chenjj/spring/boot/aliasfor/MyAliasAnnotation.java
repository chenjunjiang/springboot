package com.chenjj.spring.boot.aliasfor;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解中的属性可以互相为别名进行使用
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAliasAnnotation {
    @AliasFor(value = "location")
    String value() default "";

    @AliasFor(value = "value")
    String location() default "";
}
