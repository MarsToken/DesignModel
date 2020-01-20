package com.example.designmodel.pattern.extra.simpleFactory.multiMethod;

import com.example.designmodel.pattern.extra.simpleFactory.common.Apple;
import com.example.designmodel.pattern.extra.simpleFactory.common.Banana;
import com.example.designmodel.pattern.extra.simpleFactory.common.IFruit;

/**
 * 简单工厂模式的特点：一个工厂，多个产品，生产不同的产品，工厂分不同的厂房
 * Created by wangmaobo on 2019/12/9.
 */
public class FruitFactory {
    public IFruit productApple() {
        return new Apple();
    }

    public IFruit productBanana() {
        return new Banana();
    }
}
