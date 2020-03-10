package com.example.designmodel.pattern.create.singlePattern.lazy;

/**
 * 枚举类实现单例模式是 effective java 作者极力推荐的单例实现模式，因为枚举类型是线程安全的，
 * 并且只会装载一次，设计者充分的利用了枚举的这个特性来实现单例模式，
 * 枚举的写法非常简单，而且枚举类型是所用单例实现中唯一一种不会被破坏的单例实现模式
 * Created by hp on 2020/3/10.
 */
public class SingleInstance6 {
    private SingleInstance6() {

    }

    public static SingleInstance6 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    /**
     * 枚举类型是线程安全的，并且只会装载一次
     */
    private enum Singleton {
        INSTANCE;
        private final SingleInstance6 instance6;

        Singleton() {
            instance6 = new SingleInstance6();
        }

        private SingleInstance6 getInstance() {
            return instance6;
        }
    }

}
