package com.example.designmodel.pattern.create.singlePattern.badmash;

/**
 * 饿汉式：对于初始化工作量比较大的操作不推荐用饿汉式
 * Created by hp on 2019/12/9.
 */
public class SingleInstance {
    private static SingleInstance singleInstance = new SingleInstance();

    private SingleInstance() {
        System.out.println(Thread.currentThread().getName() + "create construct!");
    }

    public static SingleInstance getInstance() {
        return singleInstance;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + "do something!");
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return singleInstance;
    }
}
