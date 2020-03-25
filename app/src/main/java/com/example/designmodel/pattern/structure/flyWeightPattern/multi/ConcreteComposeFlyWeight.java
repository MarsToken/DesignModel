package com.example.designmodel.pattern.structure.flyWeightPattern.multi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 2020/3/21.
 */
public class ConcreteComposeFlyWeight implements FlyWeight {
    private Map<Character, FlyWeight> files = new HashMap<>();

    /**
     * 增加一个新的单纯享元对象到聚集中
     */
    public void add(Character character, FlyWeight fly) {//值是具体的single享元角色类
        files.put(character, fly);
    }

    /**
     * 外蕴状态作为参数传入到方法中
     */
    @Override
    public void operation(String status) {
        for (Object o : files.keySet()) {
            FlyWeight fly = files.get(o);
            fly.operation(status);
        }
    }
}
