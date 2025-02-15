package com.chenjj.spring.boot.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator extends AbstractHealthIndicator {
    private static final String VERSION = "1.0.0";

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        int code = checkCode();
        if (code != 0) {
            builder.down().withDetail("code", code).withDetail("version", VERSION).build();
        } else {
            builder.up().withDetail("code", code).withDetail("version", VERSION).build();
        }
    }

    private int checkCode() {
        return 0;
    }
}
