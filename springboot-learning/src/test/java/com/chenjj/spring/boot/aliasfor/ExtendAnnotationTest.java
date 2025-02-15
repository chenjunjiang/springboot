package com.chenjj.spring.boot.aliasfor;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * 这里要使用AnnotatedElementUtils，如果用AnnotationUtils会发现不起作用
 */
public class ExtendAnnotationTest {
    @Test
    public void test() {
        AnnotationBase annotationBase = AnnotatedElementUtils.findMergedAnnotation(ExtendClass.class, AnnotationBase.class);
        // AnnotationBase annotationBase = AnnotationUtils.findAnnotation(ExtendClass.class, AnnotationBase.class);
        Assert.assertTrue("", annotationBase.value().equals("extendValue"));
    }
}
