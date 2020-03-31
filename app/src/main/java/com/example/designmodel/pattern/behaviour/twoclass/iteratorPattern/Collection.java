package com.example.designmodel.pattern.behaviour.twoclass.iteratorPattern;


/**
 * Created by hp on 2020/3/30.
 */
public interface Collection {
    Iterator getIterator();

    /**
     * 获取集合里的元素
     * @param i
     * @return
     */
    Object get(int i);

    long size();
}
