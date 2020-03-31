package com.example.designmodel.pattern.behaviour.classstatus.statePattern;

/**
 * 核心思想就是：当对象的状态改变时，同时改变其行为，很好理解！
 * 就拿QQ来说，有几种状态，在线、隐身、忙碌等，每个状态对应不同的操作，
 * 而且你的好友也能看到你的状态，所以，状态模式就两点：
 * 1、可以通过改变状态来获得不同的行为。2、你的好友能同时看到你的变化
 * 应用场景：恰当的抽离可以省略过多的if嵌套
 * 比如界面UI状态，扫码状态，扫码成功，扫码失败，拉取二维码失败。。。
 * <p>
 * Created by hp on 2020/3/31.
 */
public class TestMain {
    public static void main(String[] args) {
        Status status = new Status();
        Context context = new Context(status);
        context.showUI();
        status.setStatus(Status.ONLINE);
        context.showUI();
    }
}
