package com.chenjj.spring.boot.aliasfor;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 此处@AliasFor的作用是当只使用@AnnotationChild而没有使用@AnnotationBase注解的时候，@AnnotationBase
 * 的value属性的值就是@AnnotationChild的extendValue属性的值
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@AnnotationBase
public @interface AnnotationChild {
    @AliasFor(annotation = AnnotationBase.class, attribute = "value")
    String extendValue() default "";
}
