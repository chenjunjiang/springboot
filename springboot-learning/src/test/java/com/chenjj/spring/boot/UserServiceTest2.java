package com.chenjj.spring.boot;

import com.chenjj.spring.boot.dao.UserDao;
import com.chenjj.spring.boot.model.User;
import com.chenjj.spring.boot.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UserServiceTest2 {
    private UserService userService;
    private UserDao userDao;

   /* @BeforeAll
    public void setUp() {
        userDao = mock(UserDao.class);
        when(userDao.insert(isA(User.class))).thenReturn(1);
        when(userDao.findById(anyInt())).thenReturn(new User("zhangsan", "123456"));
        userService = new UserService(userDao);
    }*/

    @Test
    public void testAdd() {
        User user = new User();
        user.setUsername("wangwu");
        user.setPassword("123456");
        System.out.println(userService.add(user));
    }

    @Test
    public void findById() {
        User user = userService.get(1);
        System.out.println(user);
    }
}
