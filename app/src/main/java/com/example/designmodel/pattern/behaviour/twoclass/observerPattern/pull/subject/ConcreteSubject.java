package com.example.designmodel.pattern.behaviour.twoclass.observerPattern.pull.subject;

/**
 * Created by hp on 2020/3/30.
 */
public class ConcreteSubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println(" begin update!");
        notifyAllObservers();
    }
}
