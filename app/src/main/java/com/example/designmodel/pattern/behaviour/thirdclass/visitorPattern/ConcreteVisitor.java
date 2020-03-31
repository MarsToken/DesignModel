package com.example.designmodel.pattern.behaviour.thirdclass.visitorPattern;

/**
 * Created by hp on 2020/3/31.
 */
public class ConcreteVisitor implements Visitor {
    @Override
    public void visit(Subject subject) {
        System.out.println("visitor visits subject,getValue=" + subject.getValue());
    }
}
