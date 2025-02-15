package com.chenjj.spring.boot.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DubboConfigConfigurationRegistrar.class)
public class SingleConfig {
}
