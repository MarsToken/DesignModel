package com.example.designmodel.pattern.create.abstractFactory.common.produce;

/**
 * 罗兰香蕉
 * Created by hp on 2019/12/9.
 */
public class LuoLanBanana implements IBanana {
    public LuoLanBanana() {
        System.out.println("product LuoLanBanana");
    }
    @Override
    public void product() {
        System.out.println("sell banana -> luo lan!");
    }
}
