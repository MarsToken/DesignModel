package com.example.designmodel.pattern.behaviour.strategyPattern;

/**
 * 个人感觉 违背聚合组合原则，继承是单一的
 * Created by hp on 2020/3/21.
 */
public class AddCalculator extends AbstractCalculator implements ICalculator {

    @Override
    public void calculate(String exp) {
        int[] result = split(exp, "\\+");
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
        }
        System.out.println(exp + "=" + sum);
    }
}
