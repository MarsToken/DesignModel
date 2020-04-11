package com.example.designmodel.pattern.behaviour.thirdclass.mediatorPattern;

/**
 * Created by hp on 2020/3/31.
 */
public class ConcreteMediator implements Mediator {
    private User user1, user2;

    @Override
    public void createMediator() {
        user1 = new User1(this);
        user2 = new User2(this);
    }

    @Override
    public void workAll() {
        user1.work();
        user2.work();
    }
}
