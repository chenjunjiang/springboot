package com.chenjj.spring.boot.configuration;

import com.chenjj.spring.boot.biz.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.*;

/**
 * @ClassName MyRoutingConfiguration
 * @Description SpringMVC 5.2 以后 允许我们使用函数式的方式，定义Web的请求处理流程
 * @Author chenjunjiang
 * @Date 14:19 2025/2/12
 * @Version 1.0
 **/

/**
 * proxyBeanMethods = false的作用：
 * 配置类声明：@Configuration 用于标记一个类为配置类，该类中可以包含一些用于定义 Bean 的方法。
 * Bean 方法代理控制：proxyBeanMethods 属性决定了是否对带有 @Bean 注解的方法进行代理，默认为 true。
 * 当设置为 false 时，每次调用 @Bean 方法都会执行方法体来获取实例，而不是从 Spring 容器中获取代理对象。
 * 性能优化：通过设置 proxyBeanMethods 为 false，可以避免 Spring 对配置类中的 @Bean 方法进行代理，
 * 从而提升应用程序的性能。在某些情况下，如果配置类中的 @Bean 方法不涉及到 AOP、事务等特性，
 * 且 Bean 之间没有依赖关系，可以考虑设置 proxyBeanMethods 为 false。
 * <p>
 * 注意：
 * 当 proxyBeanMethods 设置为 false 时，如果配置类中存在循环依赖或条件依赖的情况，
 * 可能会导致程序运行时出现问题。因此，在使用 @Configuration(proxyBeanMethods = false) 注解时，
 * 需要仔细考虑应用程序的架构和依赖关系。
 */
@Configuration(proxyBeanMethods = false)
public class MyRoutingConfiguration {
    private static final RequestPredicate ACCEPT_JSON = RequestPredicates.accept(MediaType.APPLICATION_JSON);

    @Bean
    public RouterFunction<ServerResponse> routes(UserHandler userHandler) {
        return RouterFunctions.route()
                .GET("/user/{id}", userHandler::getUser)
                .GET("/users", userHandler::getUsers)
                .POST("/user", ACCEPT_JSON, userHandler::addUser)
                .PUT("/user", ACCEPT_JSON, userHandler::updateUser)
                .DELETE("/user/{id}", userHandler::deleteUser)
                .build();
    }
}
