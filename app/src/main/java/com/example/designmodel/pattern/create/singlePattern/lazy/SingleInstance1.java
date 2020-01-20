package com.example.designmodel.pattern.create.singlePattern.lazy;

/**
 * 锁住的是方法体，每次调用getInstance方法都要其他线程都要等待，影响性能，不建议使用
 * Created by hp on 2019/12/9.
 */
public class SingleInstance1 {
    private static SingleInstance1 instance = null;

    private SingleInstance1() {
        System.out.println(Thread.currentThread().getName() + "create construct!");
    }

    public static synchronized SingleInstance1 getInstance() {
        if (null == instance) {
            instance = new SingleInstance1();
        }
        return instance;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + "do something!");
    }
}
