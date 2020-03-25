package com.example.designmodel.pattern.Test;

/**
 * Created by hp on 2020/3/13.
 */
public class Director {
    private Builder mBuilder;

    public Director(Builder builder) {
        mBuilder = builder;
    }

    public void build(String name,String vegetable) {
        mBuilder.buildName(name);
        mBuilder.buildVegetable(vegetable);
    }
}
