package com.example.designmodel.pattern.Test;

/**
 * Created by hp on 2020/3/12.
 */
public class TestMain {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        Subject subject = new ConcreteSubject();
        subject.accept(visitor);
    }
}
