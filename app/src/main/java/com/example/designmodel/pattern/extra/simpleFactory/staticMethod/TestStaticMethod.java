package com.example.designmodel.pattern.extra.simpleFactory.staticMethod;

import com.example.designmodel.pattern.extra.simpleFactory.common.IFruit;

/**
 * Created by wangmaobo on 2019/12/9.
 */
public class TestStaticMethod {
    public static void main(String[] args) {
        IFruit apple = FruitFactory.productApple();
        IFruit banana = FruitFactory.productBanana();
        apple.product();
        banana.product();
    }
}
