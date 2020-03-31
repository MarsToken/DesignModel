package com.example.designmodel.pattern.behaviour.twoclass.chainsOfResponsibilityPattern.classis;

/**
 * Created by hp on 2020/3/31.
 */
public abstract class AbstractHandler implements Handler {
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
