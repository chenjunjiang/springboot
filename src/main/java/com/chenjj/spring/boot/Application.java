package com.chenjj.spring.boot;

import io.prometheus.client.exporter.MetricsServlet;
import io.prometheus.client.hotspot.DefaultExports;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

// @RestController
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*@RequestMapping("demo1")
    public String demo1() {
        return "Hello Boot";
    }*/

    /**
     * 容器启动完成的时候执行
     *
     * @param context
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            System.out.println("来看看 SpringBoot 默认为我们提供的 Bean：");
            String[] beanNames = context.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            Arrays.stream(beanNames).forEach(System.out::println);

            // prometheus DefaultExports initialize
            DefaultExports.initialize();
        };
    }

    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MetricsServlet());
        servletRegistrationBean.addUrlMappings("/metrics");
        return servletRegistrationBean;
    }
}
