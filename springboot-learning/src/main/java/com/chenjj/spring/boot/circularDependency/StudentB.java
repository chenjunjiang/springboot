package com.chenjj.spring.boot.circularDependency;

import org.springframework.stereotype.Service;

// @Service
public class StudentB {
    private StudentC studentC;

    public StudentB(StudentC studentC) {
        this.studentC = studentC;
    }

    public void setStudentC(StudentC studentC) {
        this.studentC = studentC;
    }
}
