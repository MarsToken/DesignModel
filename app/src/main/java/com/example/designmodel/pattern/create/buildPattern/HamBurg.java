package com.example.designmodel.pattern.create.buildPattern;

/**
 * 产品抽象角色
 * Created by hp on 2020/3/10.
 */
public abstract class HamBurg {
    protected String bread;
    protected String vegetable;
    protected String name;
    protected float prize;

    public void setBread(String bread) {
        this.bread = bread;
    }

    public abstract void setPrize(float prize);

    public abstract void setName(String name);

    public void setVegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    @Override
    public String toString() {
        return "HamBurg{" +
                "bread='" + bread + '\'' +
                ", vegetable='" + vegetable + '\'' +
                ", name='" + name + '\'' +
                ", prize=" + prize +
                '}';
    }
}
