package com.example.designmodel.pattern.behaviour.thirdclass.interpretePattern;

/**
 * Created by hp on 2020/3/31.
 */
public class Minus implements Expression {
    @Override
    public int interpret(Context context) {
        return context.getNum1() - context.getNum2();
    }
}
