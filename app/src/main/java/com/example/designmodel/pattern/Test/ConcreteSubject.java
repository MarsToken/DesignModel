package com.example.designmodel.pattern.Test;

/**
 * Created by hp on 2020/3/31.
 */
public class ConcreteSubject implements Subject {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getValue() {
        return "dinner";
    }
}
