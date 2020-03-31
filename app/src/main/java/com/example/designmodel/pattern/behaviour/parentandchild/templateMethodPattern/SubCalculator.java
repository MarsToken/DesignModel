package com.example.designmodel.pattern.behaviour.parentandchild.templateMethodPattern;

/**
 * Created by hp on 2020/3/21.
 */
public class SubCalculator extends AbstractCalculator {

    @Override
    int calculate(int a, int b) {
        return a - b;
    }
}
