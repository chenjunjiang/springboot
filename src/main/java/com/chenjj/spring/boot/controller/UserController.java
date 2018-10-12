package com.chenjj.spring.boot.controller;

import com.battcn.boot.swagger.model.DataType;
import com.battcn.boot.swagger.model.ParamType;
import com.chenjj.spring.boot.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Api(tags = "1.0", description = "用户管理", value = "用户管理")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    @ApiOperation(value = "条件查询 (DONE) ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = DataType.STRING, paramType = ParamType.HEADER),
            @ApiImplicitParam(name = "password", value = "密码", dataType = DataType.STRING, paramType = ParamType.QUERY)
    })
    public User query(String username, String password) {
        log.info("多个参数用  @ApiImplicitParams");
        return new User("zhangsan", "123");
    }
}
