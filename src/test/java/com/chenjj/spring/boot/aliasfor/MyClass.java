package com.chenjj.spring.boot.aliasfor;

public class MyClass {
    // 设置后value的值和location一样
    @MyAliasAnnotation(location = "这是值1")
    public static void one() {
    }

    // 设置后location的值和value一样
    @MyAliasAnnotation(value = "这是值")
    public static void one2() {
    }

    // 如果两个属性都设置了值，那么值必须一样，否则会报错
    @MyAliasAnnotation(value = "这是值", location = "这是值")
    public static void one3() {
    }
}
