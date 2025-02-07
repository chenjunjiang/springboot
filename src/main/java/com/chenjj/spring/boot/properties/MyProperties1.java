package com.chenjj.spring.boot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Component：将MyProperties1这个类注册到Spring容器中，一定要把MyProperties1注册到Spring容器中，否则无法生效。
 * 相当于配置文件中的<bean id="myProperties1" class="com.chenjj.spring.boot.properties.MyProperties1"/>
 * @ConfigurationProperties：将MyProperties1这个类和配置文件中的my1.*进行绑定;
 */
@Component
@ConfigurationProperties(prefix = "my1")
public class MyProperties1 {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyProperties1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
