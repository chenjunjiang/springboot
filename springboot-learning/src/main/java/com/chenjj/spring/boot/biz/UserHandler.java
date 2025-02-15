package com.chenjj.spring.boot.biz;

import com.chenjj.spring.boot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @ClassName UserHandler
 * @Description
 * @Author chenjunjiang
 * @Date 14:39 2025/2/12
 * @Version 1.0
 **/
@Component
@Slf4j
public class UserHandler {
    public ServerResponse getUser(ServerRequest request) throws Exception {
        String id = request.pathVariable("id");
        log.info("获取用户【{}】的信息......", id);
        return ServerResponse.ok().body("获取信息成功");
    }

    public ServerResponse getUsers(ServerRequest request) throws Exception {
        log.info("获取所有用户信息......");
        return ServerResponse.ok().body("获取信息成功");
    }

    public ServerResponse addUser(ServerRequest request) throws Exception {
        User user = request.body(User.class);
        log.info("添加用户信息【{}】......", user);
        return ServerResponse.ok().body("添加用户信息成功");
    }

    public ServerResponse updateUser(ServerRequest request) throws Exception {
        User user = request.body(User.class);
        log.info("更新用户信息【{}】......", user);
        return ServerResponse.ok().body("更新用户信息成功");
    }

    public ServerResponse deleteUser(ServerRequest request) throws Exception {
        String id = request.pathVariable("id");
        log.info("删除用户【{}】的信息......", id);
        return ServerResponse.ok().body("删除用户信息成功");
    }
}
