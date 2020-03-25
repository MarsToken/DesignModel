package com.example.designmodel.pattern.behaviour.templateMethodPattern;

/**
 * Created by hp on 2020/3/21.
 */
public abstract class AbstractCalculator {
    public void calculate(String exp, String opt) {
        int[] result = split(exp, opt);
        int sum = calculate(result[0], result[1]);
        System.out.println(exp + "=" + sum);
    }

    private int[] split(String exp, String opt) {
        String[] exp_result = exp.split(opt);
        return new int[]{Integer.parseInt(exp_result[0]), Integer.parseInt(exp_result[1])};
    }

    abstract int calculate(int a, int b);
}
