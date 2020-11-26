package com.chenjj.spring.boot.configuration;

import com.chenjj.spring.boot.dao.TestDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public TestDao testDao(){
        /**
         * 这里不能直接返回null，否则会报：
         *The following candidates were found but could not be injected:
         * 	- User-defined bean method 'testDao' in 'TestConfig' ignored as the bean value is null
         */
        //return null;
        return new TestDao();
    }
}
