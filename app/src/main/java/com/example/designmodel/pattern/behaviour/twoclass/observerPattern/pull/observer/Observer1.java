package com.example.designmodel.pattern.behaviour.twoclass.observerPattern.pull.observer;

/**
 * Created by hp on 2020/3/30.
 */
public class Observer1 implements Observer {
    @Override
    public void update(String name) {
        System.out.println(name + "has updated!");
    }

    @Override
    public String toString() {
        return "Observer1";
    }
}
