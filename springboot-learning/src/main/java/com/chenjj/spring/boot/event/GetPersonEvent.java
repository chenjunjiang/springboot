package com.chenjj.spring.boot.event;

import com.chenjj.spring.boot.model.Person;
import org.springframework.context.ApplicationEvent;

/**
 * @ClassName GetPersonEvent
 * @Description
 * @Author chenjunjiang
 * @Date 21:26 2025/2/13
 * @Version 1.0
 **/
public class GetPersonEvent extends ApplicationEvent {
    public GetPersonEvent(Person source) {
        super(source);
    }
}
