package com.example.designmodel.pattern.extra.simpleFactory.singleMethod;

import com.example.designmodel.pattern.extra.simpleFactory.common.Apple;
import com.example.designmodel.pattern.extra.simpleFactory.common.Banana;
import com.example.designmodel.pattern.extra.simpleFactory.common.IFruit;

/**
 * 简单工厂模式的特点：一个工厂，多个产品，生产不同的产品，工厂分不同的产品线，违背开闭原则
 * Created by wangmaobo on 2019/12/9.
 */
public class FruitFactory {
    public IFruit product(String type) {
        if (Apple.class.getSimpleName().equals(type)) {
            return new Apple();
        } else if (Banana.class.getSimpleName().equals(type)) {
            return new Banana();
        } else {
            return null;
        }
    }
}
