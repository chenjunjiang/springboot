package com.chenjj.spring.boot.args;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * --test=xx,yy non-option
 */
@Component
public class ArgsBean {
    @Resource
    private ApplicationArguments applicationArguments;

    /**
     * # 非选项参数数量:1
     * # 选项参数数量:1
     * # 非选项参数具体参数:
     * non-option
     * # 选项参数具体参数:
     * --test=[xx,yy]
     */
    public void printArgs() {
        System.out.println("# 非选项参数数量:" + applicationArguments.getNonOptionArgs().size());
        System.out.println("# 选项参数数量:" + applicationArguments.getOptionNames().size());
        System.out.println("# 非选项参数具体参数:");
        applicationArguments.getNonOptionArgs().forEach(System.out::println);
        System.out.println("# 选项参数具体参数:");
        applicationArguments.getOptionNames().forEach(optionName -> {
            System.out.println("--" + optionName + "=" + applicationArguments.getOptionValues(optionName));
        });
    }
}
