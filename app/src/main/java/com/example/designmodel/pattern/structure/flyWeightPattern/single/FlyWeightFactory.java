package com.example.designmodel.pattern.structure.flyWeightPattern.single;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂角色类
 * 享元工厂角色类，必须指出的是，客户端不可以直接将具体享元类实例化，而必须通过一个工厂对象，
 * 利用一个factory()方法得到享元对象。一般而言，享元工厂对象在整个系统中只有一个，因此也可以使用单例模式
 * Created by hp on 2020/3/21.
 */
public class FlyWeightFactory {
    private Map<Character, FlyWeight> files = new HashMap<>();

    public FlyWeight product(Character status) {
        FlyWeight fly = files.get(status);
        if (fly == null) {
            fly = new ConcreteFlyWeight(status);
            files.put(status, fly);
        }
        return fly;
    }

    public int getFileSize() {
        return files.size();
    }
}
