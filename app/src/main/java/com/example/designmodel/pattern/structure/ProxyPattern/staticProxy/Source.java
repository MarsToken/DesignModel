package com.example.designmodel.pattern.structure.ProxyPattern.staticProxy;

/**
 * Created by hp on 2020/3/13.
 */
public class Source implements ISource{
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
