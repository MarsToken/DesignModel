package com.example.designmodel.pattern.create.singlePattern.lazy;

/**
 * Created by hp on 2019/12/9.
 */
public class SingleInstance4 {
    private static volatile SingleInstance4 instance = null;

    private SingleInstance4() {
        System.out.println(Thread.currentThread().getName() + "create construct!");
    }

    public static SingleInstance4 getInstance() {
        if (null == instance) {
            syncInit();
        }
        return instance;
    }

    private static synchronized void syncInit() {
        if (null == instance) {
            instance = new SingleInstance4();
        }
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + "do something!");
    }
}
