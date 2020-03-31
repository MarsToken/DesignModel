package com.example.designmodel.pattern.behaviour.classstatus.statePattern;

/**
 * Created by hp on 2020/3/31.
 */
public class Context {
    private Status status;

    public Context(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void showUI() {
        switch (status.getStatus()) {
            case Status.HIDE:
                status.HideUI();
                break;
            case Status.ONLINE:
                status.showUI();
                break;
        }
    }
}
