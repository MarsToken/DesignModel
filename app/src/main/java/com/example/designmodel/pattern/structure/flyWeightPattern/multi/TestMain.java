package com.example.designmodel.pattern.structure.flyWeightPattern.multi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2020/3/21.
 */
public class TestMain {
    public static void main(String[] args) {
        List<Character> compositeState = new ArrayList<>();
        compositeState.add('a');
        compositeState.add('b');
        compositeState.add('c');
        compositeState.add('a');
        compositeState.add('b');
        FlyWeightFactory factory = new FlyWeightFactory();
        FlyWeight compositeFly1 = factory.product(compositeState);
        FlyWeight compositeFly2 = factory.product(compositeState);
        compositeFly1.operation("Composite Call!");
        System.out.println("---------------------------------");
        //复合享元模式对象不可复用，但是复合享元模式里的单个单纯对象是可以复用的
        System.out.println("复合享元模式是否可以共享对象：" + (compositeFly1 == compositeFly2));

        Character state = 'a';
        FlyWeight fly1 = factory.product(state);
        FlyWeight fly2 = factory.product(state);
        System.out.println("单纯享元模式是否可以共享对象：" + (fly1 == fly2));
    }
}
