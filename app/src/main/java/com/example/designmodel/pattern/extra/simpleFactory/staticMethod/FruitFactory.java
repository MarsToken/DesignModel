package com.example.designmodel.pattern.extra.simpleFactory.staticMethod;

import com.example.designmodel.pattern.extra.simpleFactory.common.Apple;
import com.example.designmodel.pattern.extra.simpleFactory.common.Banana;
import com.example.designmodel.pattern.extra.simpleFactory.common.IFruit;

/**
 * 与多个方法的相比，可以省去创建工厂对象的流程
 * Created by wangmaobo on 2019/12/9.
 */
public class FruitFactory {
    public static IFruit productApple() {
        return new Apple();
    }

    public static IFruit productBanana() {
        return new Banana();
    }
}
