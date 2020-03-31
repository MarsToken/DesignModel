package com.example.designmodel.pattern.behaviour.parentandchild.templateMethodPattern;

/**
 * 一个抽象类中，有一个主方法，再定义1...n个方法，可以是抽象的，
 * 也可以是实际的方法，定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用
 * 应用场景：比如万能适配器的封装，获取layoutId，activity里的initView，intData方法等等
 * 而策略模式重写的是onCreate，initView只是其一
 * <p>
 * 在思想和意图上看，模板方法更加强调：
 * 1）定义一条线（算法流程），线上的多个点是可以变化的（具体实现在子类中完成），线上的多个点一定是会被执行的，并且一定是按照特定流程被执行的。
 * 2）算法流程只有唯一的入口，对于点的访问是受限的【通常用受保护的虚函数来定义可变点】。
 * 策略模式更注重于： 一个“策略”是一个 整体的(完整的) 算法，算法是可以被整体替换的。而模板方法只能被替换其中的特定点，算法流程是固定不可变的。
 * Created by hp on 2020/3/21.
 */
public class TestMain {
    public static void main(String[] args) {
        AbstractCalculator addCalculator = new AddCalculator();
        addCalculator.calculate("1+2", "\\+");
        AbstractCalculator subCalculator = new SubCalculator();
        subCalculator.calculate("10-2", "\\-");

    }
}
