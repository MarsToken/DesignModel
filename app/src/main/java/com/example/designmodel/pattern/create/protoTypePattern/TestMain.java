package com.example.designmodel.pattern.create.protoTypePattern;

import java.io.IOException;

/**
 * 将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象
 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。
 * 简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
 * Created by hp on 2020/3/10.
 */
public class TestMain {
    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        prototype.setString("123");
        prototype.setSerializableObject(new Prototype.SerializableObject());
        System.out.println("original=" + prototype.toString());
        try {
            Prototype prototype_low = (Prototype) prototype.clone();
            //true String为引用
            System.out.println("low,object:" + prototype_low.toString() + ",string:" + (prototype.getString() == prototype_low.getString()));
            Prototype prototype_deep = (Prototype) prototype.deepClone();
            //false
            System.out.println("deep,object:" + prototype_deep.toString() + ",string:" + (prototype.getString() == prototype_deep.getString()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
