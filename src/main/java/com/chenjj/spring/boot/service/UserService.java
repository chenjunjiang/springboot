package com.chenjj.spring.boot.service;

import com.chenjj.spring.boot.dao.UserDao;
import com.chenjj.spring.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User get(int id) {
        return userDao.findById(id);
    }

    public int add(User user) {
        return userDao.insert(user);
    }

}
