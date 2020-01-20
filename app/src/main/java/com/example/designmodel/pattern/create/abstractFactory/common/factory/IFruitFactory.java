package com.example.designmodel.pattern.create.abstractFactory.common.factory;

import com.example.designmodel.pattern.create.abstractFactory.common.produce.IApple;
import com.example.designmodel.pattern.create.abstractFactory.common.produce.IBanana;

/**
 * Created by hp on 2019/12/9.
 */
public interface IFruitFactory {
    IApple productApple();

    IBanana productBanana();
}
