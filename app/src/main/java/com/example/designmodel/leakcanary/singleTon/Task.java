package com.example.designmodel.leakcanary.singleTon;

/**
 * Created by tellerWang on 2020/12/25.
 */
public class Task {
    private Call call;
    public Call newCall(){
        this.call = new Call();
        return call;
    }
}
