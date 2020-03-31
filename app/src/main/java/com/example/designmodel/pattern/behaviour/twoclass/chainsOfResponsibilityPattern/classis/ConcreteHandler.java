package com.example.designmodel.pattern.behaviour.twoclass.chainsOfResponsibilityPattern.classis;

/**
 * Created by hp on 2020/3/31.
 */
public class ConcreteHandler extends AbstractHandler {
    private String name;

    public ConcreteHandler(String name) {
        this.name = name;
    }

    @Override
    public void onWork() {
        System.out.println(name + "has resolved!");
        if (getHandler() != null) {
            getHandler().onWork();
        }
    }
}
