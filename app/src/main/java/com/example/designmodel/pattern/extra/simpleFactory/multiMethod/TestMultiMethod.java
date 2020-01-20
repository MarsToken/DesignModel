package com.example.designmodel.pattern.extra.simpleFactory.multiMethod;

import com.example.designmodel.pattern.extra.simpleFactory.common.IFruit;

/**
 * Created by hp on 2019/12/9.
 */
public class TestMultiMethod {

    public static void main(String[] args) {
        FruitFactory fruitFactory = new FruitFactory();
        //为了便于查看代码：可用Apple，不用IFruit，参考依赖倒置原则
        IFruit apple = fruitFactory.productApple();
        IFruit banana = fruitFactory.productBanana();
        apple.product();
        banana.product();
    }
}
