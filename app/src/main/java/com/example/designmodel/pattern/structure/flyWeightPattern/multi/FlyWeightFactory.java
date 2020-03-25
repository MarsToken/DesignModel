package com.example.designmodel.pattern.structure.flyWeightPattern.multi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2020/3/21.
 */
public class FlyWeightFactory {
    private Map<Character, FlyWeight> files = new HashMap<>();

    /**
     * 复合享元工厂方法
     */
    public FlyWeight product(List<Character> compositeState) {
        ConcreteComposeFlyWeight ccFly = new ConcreteComposeFlyWeight();
        for (Character status : compositeState) {
            ccFly.add(status, this.product(status));
        }
        return ccFly;
    }

    /**
     * 单纯享元工厂方法
     */
    public FlyWeight product(Character status) {
        //先从缓存中查找对象
        FlyWeight fly = files.get(status);
        if (fly == null) {
            //如果对象不存在则创建一个新的Flyweight对象
            fly = new ConcreteFlyWeight(status);
            //把这个新的Flyweight对象添加到缓存中
            files.put(status, fly);
        }
        return fly;
    }
}
