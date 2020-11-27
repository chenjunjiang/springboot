package com.chenjj.spring.boot.circularDependency;

import org.springframework.stereotype.Service;

/**
 * 构造方法循环依赖后报错：
 * ┌─────┐
 * |  studentA defined in file [D:\workspace\springboot\target\classes\com\chenjj\spring\boot\circularDependency\StudentA.class]
 * ↑     ↓
 * |  studentB defined in file [D:\workspace\springboot\target\classes\com\chenjj\spring\boot\circularDependency\StudentB.class]
 * ↑     ↓
 * |  studentC defined in file [D:\workspace\springboot\target\classes\com\chenjj\spring\boot\circularDependency\StudentC.class]
 * └─────┘
 * Error creating bean with name 'studentA': Requested bean is currently in creation:
 * Is there an unresolvable circular reference?
 */
// @Service
public class StudentA {
    private StudentB studentB;

    public StudentA(StudentB studentB) {
        this.studentB = studentB;
    }

    public void setStudentB(StudentB studentB) {
        this.studentB = studentB;
    }
}
