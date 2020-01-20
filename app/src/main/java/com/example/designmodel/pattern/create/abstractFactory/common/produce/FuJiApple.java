package com.example.designmodel.pattern.create.abstractFactory.common.produce;

/**
 * 红富士苹果
 * Created by hp on 2019/12/9.
 */
public class FuJiApple implements IApple {
    public FuJiApple() {
        System.out.println("product FuJiApple apple");
    }
    @Override
    public void product() {
        System.out.println("sell apple -> fu ji!");
    }
}
