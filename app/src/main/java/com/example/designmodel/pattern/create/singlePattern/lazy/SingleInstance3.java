package com.example.designmodel.pattern.create.singlePattern.lazy;

/**
 *lazy-loading
 * 单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。
 * 这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，
 * 并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心上面的问题。
 * 同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。
 * Created by hp on 2019/12/9.
 */
public class SingleInstance3 {
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
