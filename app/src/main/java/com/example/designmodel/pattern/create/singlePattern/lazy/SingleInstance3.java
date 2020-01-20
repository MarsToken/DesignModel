package com.example.designmodel.pattern.create.singlePattern.lazy;

/**
 * Created by hp on 2019/12/9.
 */
public class SingleInstance3 {
    private static SingleInstance3 singleInstance = null;

    private SingleInstance3() {
        System.out.println("create instance");
    }

    public static SingleInstance3 getInstance() {
        return InnerInstance.instance;
    }

    private static class InnerInstance {
        private static final SingleInstance3 instance = new SingleInstance3();
    }
}
