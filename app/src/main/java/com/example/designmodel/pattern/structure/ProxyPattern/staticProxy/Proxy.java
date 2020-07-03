package com.example.designmodel.pattern.structure.ProxyPattern.staticProxy;

import com.example.designmodel.pattern.structure.ProxyPattern.ISource;
import com.example.designmodel.pattern.structure.ProxyPattern.Source;

/**
 * Created by hp on 2020/3/13.
 */
public class Proxy implements ISource {
    private ISource mSource;

    public Proxy() {//注意与装饰者模式的区别
        super();
        mSource = new Source();
    }

    @Override
    public void method() {
        System.out.println("before");
        mSource.method();
        System.out.println("after");
    }
}
