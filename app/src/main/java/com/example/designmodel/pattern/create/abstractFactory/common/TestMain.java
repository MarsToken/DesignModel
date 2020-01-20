package com.example.designmodel.pattern.create.abstractFactory.common;

import com.example.designmodel.pattern.create.abstractFactory.common.factory.IFruitFactory;
import com.example.designmodel.pattern.create.abstractFactory.common.factory.LianHuaFactory;
import com.example.designmodel.pattern.create.abstractFactory.common.produce.IApple;
import com.example.designmodel.pattern.create.abstractFactory.common.produce.IBanana;

/**
 * 抽象工厂模式与工厂方法模式的区别
 * 工厂方法模式针对的是一个产品等级结构；而抽象工厂模式则是针对的多个产品等级结构，所以有个产品族的概念
 * 工厂方法模式中的所有产品都是来自同一个接口或抽象类，而抽象工厂模式中的产品则是来自不同的接口或抽象类。
 * 抽象工厂模式是工厂方法模式的升级版本，在有多个业务，或者多个分类的情况下，抽象工厂模式比较适合。
 * 产品族：是指位于不同产品等级结构中，功能相关联的产品组成的家族
 * 一般而言：工厂方法模式比抽象工厂模式更抽象，在更高层，大boss
 * Created by hp on 2019/12/9.
 */
public class TestMain {
    public static void main(String[] args) {
        //联华生产红富士苹果，芝麻蕉
        IFruitFactory factory = new LianHuaFactory();
        IApple apple = factory.productApple();
        apple.product();
        IBanana banana = factory.productBanana();
        banana.product();
    }
}
