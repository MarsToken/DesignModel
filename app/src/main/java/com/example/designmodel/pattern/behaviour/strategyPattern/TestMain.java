package com.example.designmodel.pattern.behaviour.strategyPattern;

/**
 * 策略模式的决定权在用户，系统本身提供不同算法的实现，新增或者删除算法，对各种算法做封装。
 * 因此，策略模式多用在算法决策系统中，外部用户只需要决定用哪个算法即可
 * 应用场景太多了，比如onCreate等各种方法的实现
 * Created by hp on 2020/3/21.
 */
public class TestMain {
    public static void main(String[] args) {
        AddCalculator addCalculator = new AddCalculator();
        addCalculator.calculate("8+9+10");
        SubCalculator subCalculator = new SubCalculator();
        subCalculator.calculate("10-9");
    }
}
