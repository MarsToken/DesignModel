package com.example.designmodel.pattern;

/**
 * * 创建型模式：对象实例化的模式，创建型模式用于解耦对象的实例化过程。
 * * 结构型模式：把类或对象结合在一起形成一个更大的结构。
 * * 行为型模式：类和对象如何交互，及划分责任和算法。
 * 创建型模式，共五种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。
 * 结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。
 * 行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。
 * 行为关系模式：
 * 第一类：父类与子类：策略模式，模板方法模式
 * 第二类：两个类之间：观察者模式，迭代子模式，责任链模式，命令模式
 * 第三类：类的状态：备忘录模式，状态模式
 * 第四类：通过中间类：访问者模式，中介模式，解释器模式
 * <p>
 * 其实还有两类：并发型模式和线程池模式。简单工厂模式不是设计模式
 * <p>
 * 三种工厂模式的对比，简单工厂模式有（单个方法，多个方法，静态方法，一般用静态方法的）工厂没有抽象接口，每次加工厂都得改工厂类，不符合开闭原则
 * 工厂方法模式：有工厂抽象接口，适合单一需求，比如苹果工厂生产苹果，香蕉生产香蕉
 * 抽象工厂模式：适合产品簇需求，比如联华工厂生产红富士苹果和芝麻蕉
 * <p>
 * 装饰者模式和代理模式的区别：微妙的细节，巨大的反差！！！
 * 使用代理模式，代理和真实对象之间的的关系通常在编译时就已经确定了，
 * 而装饰者能够在运行时递归地被构造
 * 主要体现在：代理或装饰者的构造函数里：代理模式代理的对象不对外暴露，装饰者装饰的对象必须对外暴露
 * 第一段说的是代理模式，侧重于不能直接访问一个对象，只能通过代理来间接访问，比如对象在另外一台机器上，或者对象被持久化了，
 * 对象是受保护的。对象在另外一台机器上，其实就是rpc，感兴趣的可以看看dubbo的源码本地反问的其实就是远程对象的代理，
 * 只不过代理帮你做了访问这个对象之前和之后的很多事情，但是对使用者是透明的了。对象被持久化了，比如mybatis的mapperProxy。
 * 通过mapper文件自动生成代理类。第三种，对内核对象的访问。
 * 第二段说的是装饰器模式是因为没法在编译器就确定一个对象的功能，需要运行时动态的给对象添加职责，
 * 所以只能把对象的功能拆成一一个个的小部分，动态组装，感兴趣的可以看看dubbo的源码，里面的mock，cluster，failover
 * 都是通过装饰器来实现的。因为这些功能是由使用者动态配置的。但是代理模式在编译器其实就已经确定了和代理对象的关系。
 * 第三段说的是，这个两个设计模式是为了解决不同的问题而抽象总结出来的。是可以混用的。可以在代理的基础上在加一个装饰，
 * 也可以在装饰器的基础上在加一个代理。感兴趣的去看看dubbo源码，里面就是这么实现的。
 * <p>
 * 观察者模式：定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态发生改变时，会通知所有观察者对象，使他们能够自动更新自己。
 * 命令模式：
 * 将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可撤销的操作。
 * 作用：
 * 1、它能较容易地设计一个命令队列；
 * 2、在需要的情况下，可以较容易地将命令记入日志；
 * 3、允许接收请求的一方决定是否要否决请求；
 * 4、可以容易地实现对请求的撤销和重做；
 * 5、由于加进新的具体命令类不影响其他的类，因此增加新的具体命令类很容易。
 * 区别：
 * 命令模式发起通知方内部只有命令的对象，通过命令来完成。--通知的是命令。
 * 观察者模式发起通知的内部是接收通知的对象，通过调用接受对象的方法来完成。--通知的是接收对象，由接收对象自己执行对应的方法。
 * <p>
 * Created by hp on 2020/3/10.
 */
public class Introduce {
    public static void main(String[] args) {

    }
}
