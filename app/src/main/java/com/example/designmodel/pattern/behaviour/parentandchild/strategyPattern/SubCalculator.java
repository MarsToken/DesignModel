package com.example.designmodel.pattern.behaviour.parentandchild.strategyPattern;

/**
 * Created by hp on 2020/3/21.
 */
public class SubCalculator extends AbstractCalculator implements ICalculator{
    @Override
    public void calculate(String exp) {
        int[] result = split(exp, "\\-");
        int sum = result[0] - result[1];
        System.out.println(exp + "=" + sum);
    }
}
