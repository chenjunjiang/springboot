package com.chenjj.spring.boot.response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ReturnMessage implements Serializable {
    private static final long serialVersionUID = 8906665424145787073L;
    private String code;
    private String message;
    private Map<String, Object> context = new HashMap<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public void setContext(Map<String, Object> context) {
        this.context = context;
    }
}
