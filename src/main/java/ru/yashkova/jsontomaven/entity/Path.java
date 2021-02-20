package ru.yashkova.jsontomaven.entity;

import java.io.Serializable;

public class Path  implements Serializable {
    
    public static final long SerialVersionUID = 1L;

    @Override
    public String toString() {
        return "Path{" +
                "code='" + code + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
