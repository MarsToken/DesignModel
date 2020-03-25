package com.example.designmodel.pattern.behaviour.templateMethodPattern;

/**
 * 一个抽象类中，有一个主方法，再定义1...n个方法，可以是抽象的，
 * 也可以是实际的方法，定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用
 * 应用场景：比如万能适配器的封装，获取layoutId，activity里的initView，intData方法等等
 * Created by hp on 2020/3/21.
 */
public class TestMain {
    public static void main(String[] args) {
        AbstractCalculator addCalculator = new AddCalculator();
        addCalculator.calculate("1+2","\\+");
        AbstractCalculator subCalculator = new SubCalculator();
        subCalculator.calculate("10-2", "\\-");
    }
}
