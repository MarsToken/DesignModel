package com.example.designmodel.pattern.extra.simpleFactory.singleMethod;

import com.example.designmodel.pattern.extra.simpleFactory.common.Apple;
import com.example.designmodel.pattern.extra.simpleFactory.common.Banana;

/**
 * Created by hp on 2019/12/9.
 */
public class TestSingleMethod {
    public static void main(String... args) {
        FruitFactory fruitFactory = new FruitFactory();
        Apple apple = (Apple) fruitFactory.product(Apple.class.getSimpleName());
        Banana banana = (Banana) fruitFactory.product(Banana.class.getSimpleName());
        apple.product();
        banana.product();
    }

}
