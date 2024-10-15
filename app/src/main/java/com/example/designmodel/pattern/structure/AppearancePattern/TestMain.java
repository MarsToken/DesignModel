package com.example.designmodel.pattern.structure.AppearancePattern;

/**
 * 关联的典型场景
 *
 * 外观模式是为了解决类与类之家的依赖关系的，像spring一样，可以将类和类之间的关系配置到配置文件中，
 * 而外观模式就是将他们的关系放在一个Facade类中，降低了类类之间的耦合度，该模式中没有涉及到接口
 * 有时候flavour打包可能会通过反射创建新的对象
 * 具体场景：比如application里的初始化！
 * Created by hp on 2020/3/13.
 */
public class TestMain {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startUp();
        System.out.println("==========start run===========");
        computer.shutDown();
    }
}
