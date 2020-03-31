package com.example.designmodel.pattern.behaviour.classstatus.statePattern;

/**
 * 状态模式-核心状态类
 * Created by hp on 2020/3/31.
 */
public class Status {
    //隐身
    public static final int HIDE = 1;
    //在线
    public static final int ONLINE = 2;
    public static final int DEFAULT = HIDE;
    private int status = DEFAULT;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void HideUI() {
        System.out.println("I am hided");
    }

    public void showUI() {
        System.out.println("I am online");
    }
}
