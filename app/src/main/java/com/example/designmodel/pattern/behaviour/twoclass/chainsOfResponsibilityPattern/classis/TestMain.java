package com.example.designmodel.pattern.behaviour.twoclass.chainsOfResponsibilityPattern.classis;

/**
 * 有多个对象，每个对象持有对下一个对象的引用，这样就会形成一条链，请求在这条链上传递，直到某一对象决定处理该请求。
 * 但是发出者并不清楚到底最终那个对象会处理该请求，所以，责任链模式可以实现，在隐瞒客户端的情况下，对系统进行动态的调整
 * 比如android里的事件分发机制，模拟见 dispatchEvent-隧道式分发冒泡式上传
 * Created by hp on 2020/3/30.
 */
public class TestMain {

    public static void main(String[] args) {
        AbstractHandler boss = new ConcreteHandler("Boss");
        AbstractHandler leader = new ConcreteHandler("Leader");
        AbstractHandler employee = new ConcreteHandler("employee");
        boss.setHandler(leader);
        leader.setHandler(employee);
        boss.onWork();
    }
}
