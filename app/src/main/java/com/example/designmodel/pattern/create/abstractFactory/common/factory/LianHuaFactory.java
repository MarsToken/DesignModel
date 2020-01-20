package com.example.designmodel.pattern.create.abstractFactory.common.factory;

import com.example.designmodel.pattern.create.abstractFactory.common.produce.FuJiApple;
import com.example.designmodel.pattern.create.abstractFactory.common.produce.IApple;
import com.example.designmodel.pattern.create.abstractFactory.common.produce.IBanana;
import com.example.designmodel.pattern.create.abstractFactory.common.produce.ZhiMaBanana;

/**
 * 联华工厂
 * Created by hp on 2019/12/9.
 */
public class LianHuaFactory implements IFruitFactory {
    @Override
    public IApple productApple() {
        return new FuJiApple();
    }

    @Override
    public IBanana productBanana() {
        return new ZhiMaBanana();
    }
}
