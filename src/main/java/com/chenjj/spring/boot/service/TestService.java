package com.chenjj.spring.boot.service;

import com.chenjj.spring.boot.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private TestDao testDao;
}
