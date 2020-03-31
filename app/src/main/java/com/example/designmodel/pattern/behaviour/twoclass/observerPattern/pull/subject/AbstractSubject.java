package com.example.designmodel.pattern.behaviour.twoclass.observerPattern.pull.subject;

import com.example.designmodel.pattern.behaviour.twoclass.observerPattern.pull.observer.Observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by hp on 2020/3/30.
 */
public abstract class AbstractSubject implements Subject {
    Vector<Observer> mObservers = new Vector<>();

    @Override
    public void add(Observer observer) {
        mObservers.add(observer);
    }

    @Override
    public void del(Observer observer) {
        mObservers.remove(observer);
    }

    /**
     * 调用时机视具体需求而定
     */
    @Override
    public void notifyAllObservers() {
        Enumeration<Observer> elements = mObservers.elements();
        while (elements.hasMoreElements()) {
            Observer observer = elements.nextElement();
            observer.update(observer.toString());
        }
    }

}
