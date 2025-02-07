package com.chenjj.spring.boot.controller;

import com.chenjj.spring.boot.model.User;
import com.chenjj.spring.boot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*@RestController
@RequestMapping("/users")
@Api(tags = "1.0", description = "用户管理", value = "用户管理")*/
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    /*@ApiOperation(value = "条件查询 (DONE) ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = DataType.STRING, paramType = ParamType.HEADER),
            @ApiImplicitParam(name = "password", value = "密码", dataType = DataType.STRING, paramType = ParamType.QUERY)
    })*/
    public User query(String username, String password) {
        log.info("多个参数用  @ApiImplicitParams");
        return new User("zhangsan", "123");
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") int id) {
        return userService.get(id);
    }
}
