package com.example.designmodel.pattern.behaviour.strategyPattern;

/**
 * 辅助工具类，可有可无
 * Created by hp on 2020/3/21.
 */
public abstract class AbstractCalculator {

    public int[] split(String exp, String opt) {
        String[] exp_split = exp.split(opt);
        int length = exp_split.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = Integer.parseInt(exp_split[i]);
        }
        return result;
    }
}
