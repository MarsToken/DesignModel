package com.example.designmodel.pattern.create.singlePattern.badmash;

/**
 * Created by hp on 2019/12/9.
 */
public class TestMain {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    SingleInstance singleInstance = SingleInstance.getInstance();
                    singleInstance.execute();

                }
            }).start();
        }
    }
}
