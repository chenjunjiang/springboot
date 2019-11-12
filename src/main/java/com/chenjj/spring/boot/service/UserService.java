package com.chenjj.spring.boot.service;

import com.chenjj.spring.boot.dao.UserDao;
import com.chenjj.spring.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User get(int id) {
        return userDao.findById(id);
    }

}
