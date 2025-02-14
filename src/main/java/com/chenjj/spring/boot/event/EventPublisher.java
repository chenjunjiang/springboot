package com.chenjj.spring.boot.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @ClassName EventPublisher
 * @Description 事件发布者，实现ApplicationEventPublisherAware后，发布的时间可以被spring监听到
 * @Author chenjunjiang
 * @Date 21:31 2025/2/13
 * @Version 1.0
 **/
@Service
public class EventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishEvent(GetPersonEvent getPersonEvent) {
        applicationEventPublisher.publishEvent(getPersonEvent);
    }
}
