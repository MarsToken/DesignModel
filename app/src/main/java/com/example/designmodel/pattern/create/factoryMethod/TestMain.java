package com.example.designmodel.pattern.create.factoryMethod;

import com.example.designmodel.pattern.create.factoryMethod.common.factory.AppleFactory;
import com.example.designmodel.pattern.create.factoryMethod.common.factory.BananaFactory;
import com.example.designmodel.pattern.create.factoryMethod.common.factory.IFruitFactory;
import com.example.designmodel.pattern.extra.simpleFactory.common.IFruit;

/**
 * Created by hp on 2019/12/9.
 */
public class TestMain {
    public static void main(String[] args) {
        IFruitFactory appleFactory = new AppleFactory();
        IFruit apple = appleFactory.productFruit();
        apple.product();
        IFruitFactory bananaFactory = new BananaFactory();
        IFruit banana = bananaFactory.productFruit();
        banana.product();
    }
}
