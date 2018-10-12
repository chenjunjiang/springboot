package com.chenjj.spring.boot.controller;

import com.chenjj.spring.boot.properties.MyProperties1;
import com.chenjj.spring.boot.properties.MyProperties2;
import com.chenjj.spring.boot.response.ReturnMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/properties")
@RestController
@Api(tags = "1.0", description = "属性管理", value = "属性管理")
public class PropertiesController {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesController.class);

    private final MyProperties1 myProperties1;
    private final MyProperties2 myProperties2;

    /**
     * Spring4.x 以后，推荐使用构造函数的形式注入属性
     *
     * @param myProperties1
     */
    @Autowired
    public PropertiesController(MyProperties1 myProperties1, MyProperties2 myProperties2) {
        this.myProperties1 = myProperties1;
        this.myProperties2 = myProperties2;
    }

    @GetMapping("/1")
    @ApiOperation(value = "查询第一个属性")
    public ReturnMessage myProperties1() {
        logger.info("===============================");
        logger.info(myProperties1.toString());
        logger.info("===============================");
        Map<String, Object> context = new HashMap<>();
        context.put("age", myProperties1.getAge());
        context.put("name", myProperties1.getName());
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setCode("00");
        returnMessage.setMessage("属性获取成功");
        returnMessage.setContext(context);
        return returnMessage;
    }

    @GetMapping("/2")
    public ReturnMessage myProperties2() {
        logger.info("===============================");
        logger.info(myProperties2.toString());
        logger.info("===============================");
        Map<String, Object> context = new HashMap<>();
        context.put("age", myProperties2.getAge());
        context.put("name", myProperties2.getName());
        context.put("email", myProperties2.getEmail());
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setCode("00");
        returnMessage.setMessage("属性获取成功");
        returnMessage.setContext(context);
        return returnMessage;
    }
}
