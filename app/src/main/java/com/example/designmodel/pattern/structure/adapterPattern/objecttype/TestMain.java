package com.example.designmodel.pattern.structure.adapterPattern.objecttype;

/**
 * 应用场景:类的适配器模式 比如自定义View 实现某些功能，flavor打包，定制需求，setVisible
 * 接口：比如baseActivity abstract 实现所有的view里的抽象方法，其他activity根据需求自定义实现自己需要的
 * 再比如用户中心的登录，登出，头像更新等等，通过观察者模式
 * 类方法的实现
 * 基本思路和类的适配器模式相同，只是将Adapter类作修改，这次不继承Source类，而是持有Source类的实例，以达到解决兼容性的问题
 * Created by hp on 2020/3/10.
 */
public class TestMain {
    public static void main(String[] args) {
        Source source = new Source();
        Wrapper wrapper = new Wrapper(source);
        wrapper.method1();
        wrapper.method2();
    }
}
