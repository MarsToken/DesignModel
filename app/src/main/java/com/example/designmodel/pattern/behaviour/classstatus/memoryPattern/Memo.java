package com.example.designmodel.pattern.behaviour.classstatus.memoryPattern;

/**
 * Created by hp on 2020/3/31.
 */
public class Memo {
    private String value;

    public Memo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value == null ? "" : value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
