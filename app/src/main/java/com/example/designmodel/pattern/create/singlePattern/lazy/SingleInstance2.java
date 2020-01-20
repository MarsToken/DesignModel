package com.example.designmodel.pattern.create.singlePattern.lazy;

/**
 * Created by hp on 2019/12/9.
 */
public class SingleInstance2 {
    private static volatile SingleInstance2 instance = null;

    private SingleInstance2() {
        System.out.println(Thread.currentThread().getName() + "create construct!");
    }

    public static SingleInstance2 getInstance() {
        if (null == instance) {//确保只有第一次为null才创建对象
            synchronized (SingleInstance2.class) {
                if (null == instance) {
                    instance = new SingleInstance2();
                }
            }
        }
        return instance;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + "do something!");
    }
}
