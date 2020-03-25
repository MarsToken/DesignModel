package com.example.designmodel.pattern.create.buildPattern;

/**
 * 经典构建者模式有以下几个角色：
 * 构建者角色、指导者、产品角色。
 * 职责：指导者引导构建者构建产品-聚合组合
 * 构建者模式的优缺点：
 * 在创建者模式中，客户端不再负责对象的创建与组装，而是把这个对象创建的责任交给其具体的创建者类，把组装的责任交给组装类，客户端只负责对象的调用，从而明确了各个类的职责。
 * 虽然利用创建者模式可以创建出不同类型的产品，但是如果产品之间的差异巨大，则需要编写多个创建者类才能实现，如果这是结合工厂模式更好。
 * 用途：实际开发很少出现构建这么多对象和，可以简化构建者，指导者，产品者的程序，比如retrofit构建及自定义view设置默认属性等
 * Created by hp on 2019/12/9.
 */
public class TestMain {
    public static void main(String[] args) {
        Builder builder = new ChineseHamBugBuilder();
        Director director = new Director(builder);
        director.construct("潼关膜", "生菜");
        HamBurg hamBurg = builder.create();
        System.out.println(hamBurg.toString());
    }
}
