package com.example.designmodel.pattern.create.factoryMethod.common.factory;

import com.example.designmodel.pattern.extra.simpleFactory.common.Apple;
import com.example.designmodel.pattern.extra.simpleFactory.common.IFruit;

/**
 * 简单工厂模式有一个问题就是，类的创建依赖工厂类，也就是说，如果想要拓展程序，必须对工厂类进行修改，这违背了闭包原则，这样做解决了这个问题
 * Created by wangmaobo on 2019/12/9.
 */
public class AppleFactory implements IFruitFactory {
    @Override
    public IFruit productFruit() {
        return new Apple();
    }
}
