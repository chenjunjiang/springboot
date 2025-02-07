package com.chenjj.spring.boot.configuration;

import org.springframework.context.annotation.Configuration;

/**
 * 无需安全认证就允许spring boot admin server访问client endpoint
 */
/*@Configuration
public class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll()
                .and().csrf().disable();
    }
}*/
