package com.example.designmodel.pattern.behaviour.twoclass.iteratorPattern;

/**
 * Created by hp on 2020/3/30.
 */
public interface Iterator {
    Object previous();

    Object next();

    boolean hasNext();

    Object first();
}
