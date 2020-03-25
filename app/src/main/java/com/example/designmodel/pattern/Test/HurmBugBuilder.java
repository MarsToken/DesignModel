package com.example.designmodel.pattern.Test;

/**
 * Created by hp on 2020/3/13.
 */
public class HurmBugBuilder extends Builder {
    private HurmBug mHurmBug;

    public HurmBugBuilder(HurmBug hurmbug) {
        this.mHurmBug = hurmbug;
    }

    @Override
    void buildName(String name) {
        mHurmBug.setName(name);
    }

    @Override
    void buildVegetable(String vegetable) {
        mHurmBug.setVegetable(vegetable);
    }
}
