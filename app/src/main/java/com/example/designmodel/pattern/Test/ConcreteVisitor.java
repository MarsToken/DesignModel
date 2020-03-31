package com.example.designmodel.pattern.Test;

/**
 * Created by hp on 2020/3/31.
 */
public class ConcreteVisitor implements Visitor{
    @Override
    public void visit(Subject subject) {
        System.out.println(subject.getValue());
    }
}
