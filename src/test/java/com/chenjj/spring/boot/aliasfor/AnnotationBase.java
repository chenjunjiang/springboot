package com.chenjj.spring.boot.aliasfor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * https://blog.csdn.net/ab411919134/article/details/81782269
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AnnotationBase {
    String value() default "";
}
