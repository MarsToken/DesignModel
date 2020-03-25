package com.example.designmodel.pattern.structure.DecoratePattern;

/**
 * Created by hp on 2020/3/13.
 */
public class Decorator implements ISource {
    private ISource mSource;

    public Decorator(ISource source) {//注意与代理模式的区别
        mSource = source;
    }

    @Override
    public void method() {
        System.out.println("插入的功能1");
        mSource.method();
        System.out.println("插入的功能2");
    }
}
