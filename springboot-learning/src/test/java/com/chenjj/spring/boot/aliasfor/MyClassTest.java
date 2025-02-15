package com.chenjj.spring.boot.aliasfor;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.function.Consumer;

public class MyClassTest {
    @Test
    public void test1() throws NoSuchMethodException {
        Consumer<MyAliasAnnotation> logic = a -> {
            //Assert.assertTrue("", "这是值".equals(a.value()));
            System.out.println(a.value()+":"+a.location());
            Assert.assertTrue("", a.value().equals(a.location()));
        };

        MyAliasAnnotation aliasAnnotation = AnnotationUtils.findAnnotation(MyClass.class.getMethod("one"), MyAliasAnnotation.class);
        logic.accept(aliasAnnotation);

        MyAliasAnnotation aliasAnnotation2 = AnnotationUtils.findAnnotation(MyClass.class.getMethod("one2"), MyAliasAnnotation.class);
        logic.accept(aliasAnnotation2);

        MyAliasAnnotation aliasAnnotation3 = AnnotationUtils.findAnnotation(MyClass.class.getMethod("one3"), MyAliasAnnotation.class);
        logic.accept(aliasAnnotation3);

    }

}
