package com.example.designmodel.pattern.structure.DecoratePattern;


/**
 * 装饰器模式的应用场景：
 * 1、需要扩展一个类的功能。
 * 2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。）
 * 个人理解，其实继承也可以做到的，通过super控制，但是违背了设计模式-合成复用原则（Composite Reuse Principle）
 * 缺点：产生过多相似的对象，不易排错！
 */
public class TestMain {
    public static void main(String[] args) {
        ISource source = new Source();
        Decorator decorator = new Decorator(source);
        decorator.method();
    }
}
