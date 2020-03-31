package com.example.designmodel.pattern.behaviour.twoclass.commandPattern;

/**
 * Created by hp on 2020/3/31.
 */
public class ConcreteCommand implements Command {
    private Soldier soldier;

    public ConcreteCommand(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public void exec() {
        System.out.println("I am commended!");
        soldier.action();
    }
}
