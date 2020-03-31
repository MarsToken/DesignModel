package com.example.designmodel.pattern.behaviour.twoclass.iteratorPattern;

/**
 * 顾名思义，迭代器模式就是顺序访问聚集中的对象，一般来说，集合中非常常见
 * 这句话包含两层意思：一是需要遍历的对象，即聚集对象，二是迭代器对象，用于对聚集对象进行遍历访问
 * Created by hp on 2020/3/30.
 */
public class TestMain {
    public static void main(String[] args) {
        Collection collection = new ConcreteCollection();
        Iterator iterator = collection.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
