package com.example.designmodel.pattern.behaviour.twoclass.commandPattern;

/**
 * Created by hp on 2020/3/31.
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        System.out.println("I am sending a command!");
        command.exec();
    }
}
