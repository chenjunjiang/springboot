package com.chenjj.spring.boot.properties;

import com.chenjj.spring.boot.model.Cat;
import com.chenjj.spring.boot.model.Child;
import com.chenjj.spring.boot.model.Dog;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PersonProperties
 * @Description：@Component：将MyProperties1这个类注册到Spring容器中，一定要把MyProperties1注册到Spring容器中，否则无法生效。
 * 相当于配置文件中的<bean id="personProperties" class="com.chenjj.spring.boot.properties.PersonProperties"/>
 * @ConfigurationProperties：将MyProperties1这个类和配置文件中的person.*进行绑定;
 * @Author chenjunjiang
 * @Date 13:07 2025/2/8
 * @Version 1.0
 **/

@Component
@ConfigurationProperties(prefix = "person")
@Data
public class PersonProperties {
    private String name;
    private int age;
    private Date birthday;
    private boolean like;
    private Child child;
    private List<Dog> dogs;
    private Map<String, Cat> cats;
}
