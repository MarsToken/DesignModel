package com.example.designmodel.pattern.behaviour.twoclass.observerPattern.pull;

import com.example.designmodel.pattern.behaviour.twoclass.observerPattern.pull.observer.Observer1;
import com.example.designmodel.pattern.behaviour.twoclass.observerPattern.pull.observer.Observer2;
import com.example.designmodel.pattern.behaviour.twoclass.observerPattern.pull.subject.ConcreteSubject;

/**
 * Created by hp on 2020/3/30.
 */
public class TestMain {
    public static void main(String[] args) {
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        ConcreteSubject subject = new ConcreteSubject();
        subject.add(observer1);
        subject.add(observer2);
        subject.operation();
        subject.del(observer1);
        subject.del(observer2);
    }
}
