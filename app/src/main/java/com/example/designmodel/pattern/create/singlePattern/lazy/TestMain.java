package com.example.designmodel.pattern.create.singlePattern.lazy;

/**
 * Created by hp on 2019/12/9.
 */
public class TestMain {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    //SingleInstance1 singleInstance = SingleInstance1.getInstance();
                    SingleInstance2 singleInstance = SingleInstance2.getInstance();
                    singleInstance.execute();

                }
            }).start();
        }
    }
}
