package com.example.designmodel.pattern.behaviour.classstatus.memoryPattern;

/**
 * 主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象，个人觉得叫备份模式更形象些，通俗的讲下：
 * 假设有原始类A，A中有各种属性，A可以决定需要备份的属性，
 * 备忘录类B是用来存储A的一些内部状态，
 * 类C呢，就是一个用来存储备忘录的，且只能存储，不能修改等操作
 * <p>
 * 就是为了存储一些临时状态，这些状态不需要硬件缓存做支持-memo不会对外暴露，是Storage的一个变量，实际上是通过缓存memo对象实现的
 * 应用场景：
 * 在android中备忘录模式最典型的例子就是activity活动状态中  保存和恢复  就是采用备忘录模式
 * 1.在一个活动暂停或停止时调用活动的onSaveInstanceState(Bundle outState)函数把ACTIVITY的当前状态保存到Bundle对象中，
 * 2.活动恢复或重新启动时调用活动的onRestoreInstanceState(Bundle savedInstanceState)函数恢复到原先状态。 
 * 实际使用：
 * 比如操作工单时，有n步操作，有可能只进行了一部分就异常终止或退出了，而且下次登录不需要这些状态！类似草稿箱功能
 * 再比如 三级缓存里的内存缓存等
 * Created by hp on 2020/3/31.
 */
public class TestMain {
    public static void main(String[] args) {
        Original origin = new Original("monkey");
        Storage storage = new Storage(origin.createMemo());
        System.out.println("初始状态：" + origin.getValue());
        origin.setValue("elephant");
        System.out.println("修改后的状态：" + origin.getValue());
        origin.restoreMemo(storage.getMemo());
        System.out.println("恢复后的状态：" + origin.getValue());
    }
}
