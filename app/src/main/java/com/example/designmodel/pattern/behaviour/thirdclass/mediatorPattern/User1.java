package com.example.designmodel.pattern.behaviour.thirdclass.mediatorPattern;

/**
 * Created by hp on 2020/3/31.
 */
public class User1 extends User{

    public User1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user1 execute!");
    }
}
