package com.example.designmodel.pattern.create.buildPattern;

/**
 * 导演组装类
 * Created by hp on 2020/3/10.
 */
public class Director {
    private Builder mBuilder;

    public Director(Builder builder) {
        mBuilder = builder;
    }

    public Builder construct(String bread, String vegetable) {
        mBuilder.buildBread(bread);
        mBuilder.buildVegetable(vegetable);
        return mBuilder;
    }
}
