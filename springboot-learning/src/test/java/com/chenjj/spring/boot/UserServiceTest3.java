package com.chenjj.spring.boot;

import com.chenjj.spring.boot.dao.UserDao;
import com.chenjj.spring.boot.model.User;
import com.chenjj.spring.boot.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

public class UserServiceTest3 {
    private UserService userService;
    // 使用注解来mock一个对象
    @Mock
    private UserDao userDao;

    /*@Before
    public void setUp() {
        // 必须加上这句
        MockitoAnnotations.initMocks(this);

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
