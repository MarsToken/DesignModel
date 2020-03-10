package com.example.designmodel.pattern.create.buildPattern;

/**
 * 产品具体角色
 * Created by hp on 2020/3/10.
 */
public class ChineseHamBurg extends HamBurg {
    {
        prize = 0;
        name = "humburg";
        bread = "bread";
        vegetable = "西蓝花";
    }

    @Override
    public void setPrize(float prize) {
        this.prize = prize;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
