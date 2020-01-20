package com.example.designmodel.pattern.create.abstractFactory.common.produce;

/**
 * 芝麻蕉
 * Created by hp on 2019/12/9.
 */
public class ZhiMaBanana implements IBanana {
    public ZhiMaBanana() {
        System.out.println("product ZhiMaBanana");
    }
    @Override
    public void product() {
        System.out.println("sell banana -> zhi ma");
    }
}
