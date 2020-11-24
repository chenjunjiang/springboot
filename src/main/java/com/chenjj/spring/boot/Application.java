package com.chenjj.spring.boot;

import com.chenjj.spring.boot.args.ArgsBean;
import com.chenjj.spring.boot.configuration.LoginUserConfig;
import com.chenjj.spring.boot.configuration.WithoutAnnoConfiguration;
import com.chenjj.spring.boot.initializer.CustomApplicationContextInitializer;
import io.prometheus.client.exporter.MetricsServlet;
import io.prometheus.client.hotspot.DefaultExports;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@SpringBootApplication
// @EnableConfigurationProperties(value = LoginUserConfig.class )
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        ArgsBean argsBean = context.getBean(ArgsBean.class);
        argsBean.printArgs();

        /*SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addInitializers(new CustomApplicationContextInitializer());
        springApplication.setBannerMode(Banner.Mode.OFF);
        Set<String> set = new HashSet<>();
        set.add(WithoutAnnoConfiguration.class.getName());
        springApplication.setSources(set);
        ConfigurableApplicationContext context = springApplication.run(args);
        WithoutAnnoConfiguration withoutAnnoConfiguration = context
                .getBean(WithoutAnnoConfiguration.class);
        System.out.println(withoutAnnoConfiguration.getName());*/

        /*new SpringApplicationBuilder(Application.class)
                .web(WebApplicationType.NONE) // .REACTIVE, .SERVLET
                .run(args);*/
        System.out.println("Application started");
    }

    @RequestMapping("/")
    public String demo1() {
        return "Hello Boot";
    }

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
