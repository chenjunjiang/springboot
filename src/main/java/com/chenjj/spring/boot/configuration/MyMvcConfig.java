package com.chenjj.spring.boot.configuration;

import com.chenjj.spring.boot.component.MyXxxHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyMvcConfig
 * @Description 自定义WebMvcConfigurer可以实现WebMvcConfigurer，也可以在内部自定义bean
 * 用@Configuration + 配置WebMvcConfigurer的方式既可以保留SpringBoot默认的配置，也可以保留自定义的配置；
 * 用@Configuration + 配置WebMvcConfigurer + @EnableWebMvc的方式就会禁用自动配置效果全用自定义设置
 * @Author chenjunjiang
 * @Date 18:55 2025/2/10
 * @Version 1.0
 **/
@Configuration
// @EnableWebMvc
public class MyMvcConfig /*implements WebMvcConfigurer*/ {
    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/","classpath:/a/","classpath:/b/")
                .setCacheControl(CacheControl.maxAge(3600, TimeUnit.SECONDS));
    }*/
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/", "classpath:/a/", "classpath:/b/").setCacheControl(CacheControl.maxAge(3600, TimeUnit.SECONDS));
            }

            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
                // 配置一个能把对象转为csv格式的messageConverter
                converters.add(new MyXxxHttpMessageConverter());
            }
        };
        return webMvcConfigurer;
    }

}
