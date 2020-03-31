package com.example.designmodel.pattern.behaviour.twoclass.observerPattern.pull.subject;

import com.example.designmodel.pattern.behaviour.twoclass.observerPattern.pull.observer.Observer;

/**
 * Created by hp on 2020/3/30.
 */
public interface Subject {
    void add(Observer observer);

    void del(Observer observer);

    void notifyAllObservers();

    /**
     * 自身操作
     */
    void operation();
}
