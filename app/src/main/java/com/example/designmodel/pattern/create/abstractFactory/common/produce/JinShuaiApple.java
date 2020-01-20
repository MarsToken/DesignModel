package com.example.designmodel.pattern.create.abstractFactory.common.produce;

/**
 * 金帅苹果
 * Created by hp on 2019/12/9.
 */
public class JinShuaiApple implements IApple{
    public JinShuaiApple() {
        System.out.println("product JinShuaiApple apple");
    }
    @Override
    public void product() {
        System.out.println("sell apple -> jin shuai");
    }
}
