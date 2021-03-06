package com.example.designmodel.pattern.create.factoryMethod.common.factory;

import com.example.designmodel.pattern.extra.simpleFactory.common.Banana;
import com.example.designmodel.pattern.extra.simpleFactory.common.IFruit;

/**
 * Created by hp on 2019/12/9.
 */
public class BananaFactory implements IFruitFactory {
    @Override
    public IFruit productFruit() {
        return new Banana();
    }
}
