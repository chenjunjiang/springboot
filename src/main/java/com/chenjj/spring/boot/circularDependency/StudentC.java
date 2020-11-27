package com.chenjj.spring.boot.circularDependency;

import org.springframework.stereotype.Service;

// @Service
public class StudentC {
    private StudentA studentA;

    public StudentC(StudentA studentA) {
        this.studentA = studentA;
    }

    public void setStudentA(StudentA studentA) {
        this.studentA = studentA;
    }
}
