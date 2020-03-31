package com.example.designmodel.pattern.Test;

/**
 * Created by hp on 2020/3/31.
 */
public interface Subject {
    void accept(Visitor visitor);

    String getValue();
}
