package com.example.designmodel.pattern.behaviour.twoclass.commandPattern;

/**
 * 司令员下令让士兵去干件事情，从整个事情的角度来考虑，司令员的作用是，发出口令，口令经过传递，传到了士兵耳朵里，士兵去执行。
 * 这个过程好在，三者相互解耦，任何一方都不用去依赖其他人，只需要做好自己的事儿就行，司令员要的是结果，不会去关注到底士兵是怎么实现的
 * 比如 PackageManager
 * Created by hp on 2020/3/30.
 */
public class TestMain {
    //与观察者模式相比 多了个命令类，实现了逻辑解耦，不需要注册监听，在发送的命令多样化时方便管理命令
    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        Command command = new ConcreteCommand(soldier);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
