package com.example.designmodel.pattern.behaviour.thirdclass.mediatorPattern;

/**
 * User 持有 mediator感觉是多余的
 *
 * Created by hp on 2020/3/31.
 */
public abstract class User {
    private Mediator mediator;

    public Mediator getMediator() {
        return mediator;
    }

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void work();
}
