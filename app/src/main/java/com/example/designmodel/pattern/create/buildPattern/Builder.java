package com.example.designmodel.pattern.create.buildPattern;

/**
 * 抽象构建者
 * Created by hp on 2020/3/10.
 */
public abstract class Builder {
    public abstract void buildBread(String bread);

    public abstract void buildVegetable(String vegetable);

    public abstract void buildPrize(float prize);

    public abstract void buildName(String name);

    public abstract HamBurg create();

}
