package com.chenjj.spring.boot.configuration;

import com.chenjj.spring.boot.endpoint.MyEndPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class EndPointConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MyEndPoint myEndPoint() {
        return new MyEndPoint();
    }
}
