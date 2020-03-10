package com.example.designmodel.pattern.create.singlePattern.badmash;

/**
 * 饿汉式的变种
 * 使用static来定义静态成员变量或静态代码，借助Class的类加载机制实现线程安全单例
 * Created by hp on 2020/3/10.
 */
public class SingleInstance1 {
    private static SingleInstance1 singleInstance = null;

    static {
        singleInstance = new SingleInstance1();
    }

    private SingleInstance1() {
        System.out.println(Thread.currentThread().getName() + "create construct!");
    }

    public static SingleInstance1 getInstance() {
        return singleInstance;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + "do something!");
    }

}
