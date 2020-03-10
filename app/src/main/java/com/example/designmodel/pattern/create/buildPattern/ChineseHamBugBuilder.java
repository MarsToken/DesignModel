package com.example.designmodel.pattern.create.buildPattern;

/**
 * 具体构建者
 * Created by hp on 2020/3/10.
 */
public class ChineseHamBugBuilder extends Builder {
    private ChineseHamBurg mHamBurg;

    {
        mHamBurg = new ChineseHamBurg();
    }

    @Override
    public void buildBread(String bread) {
        mHamBurg.setBread(bread);
    }

    @Override
    public void buildVegetable(String vegetable) {
        mHamBurg.setVegetable(vegetable);
    }

    @Override
    public void buildPrize(float prize) {
        mHamBurg.setPrize(prize);
    }

    @Override
    public void buildName(String name) {
        mHamBurg.setName(name);
    }

    @Override
    public HamBurg create() {
        return mHamBurg;
    }
}
