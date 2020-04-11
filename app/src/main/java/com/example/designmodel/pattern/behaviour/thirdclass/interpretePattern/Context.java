package com.example.designmodel.pattern.behaviour.thirdclass.interpretePattern;

/**
 * Created by hp on 2020/3/31.
 */
public class Context {
    private int num1;
    private int num2;

    public Context(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num) {
        num1 = num;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num) {
        num2 = num;
    }

}
