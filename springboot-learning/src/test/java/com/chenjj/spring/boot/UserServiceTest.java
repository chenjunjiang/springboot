package com.chenjj.spring.boot;

import com.chenjj.spring.boot.model.User;
import com.chenjj.spring.boot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testAdd(){
        User user = new User();
        user.setUsername("wangwu");
        user.setPassword("123456");
        userService.add(user);
    }
}
