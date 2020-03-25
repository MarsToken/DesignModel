package com.example.designmodel.pattern.structure.flyWeightPattern.single;

/**
 * 抽象享元角色类
 * Created by hp on 2020/3/21.
 */
public interface FlyWeight {
    //一个示意性方法，参数state是外蕴状态
    void operation(String status);
}
