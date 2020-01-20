package com.example.designmodel.pattern.create.singlePattern;

/**
 * Created by hp on 2019/12/9.
 */
public class TestVolatile {
    private volatile boolean stop = false;

    public static void main(String[] args) {
        TestVolatile testVolatile = new TestVolatile();
        testVolatile.test();
    }

    private void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stop) {//不加stop可能会死循环
                    System.out.println(Thread.currentThread().getName() + "print");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                stop = true;
            }
        }).start();
    }
}
