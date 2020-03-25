package com.example.designmodel.pattern.Test;

/**
 * Created by hp on 2020/3/13.
 */
public class ChineseHurmbug extends HurmBug {
    @Override
    void setName(String name) {
        this.name = name;
    }

    @Override
    void setVegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    @Override
    public String toString() {
        return "ChineseHurmbug{" +
                "name='" + name + '\'' +
                ", vegetable='" + vegetable + '\'' +
                '}';
    }
}
