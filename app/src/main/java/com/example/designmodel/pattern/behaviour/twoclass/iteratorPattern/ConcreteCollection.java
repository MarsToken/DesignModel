package com.example.designmodel.pattern.behaviour.twoclass.iteratorPattern;


/**
 * Created by hp on 2020/3/30.
 */
public class ConcreteCollection implements Collection {
    private String[] strings = new String[]{"A", "B", "C", "D", "E"};

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(this);
    }

    @Override
    public Object get(int i) {
        return strings[i];
    }

    @Override
    public long size() {
        return strings.length;
    }
}
