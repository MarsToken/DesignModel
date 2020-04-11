package com.example.designmodel.pattern.behaviour.thirdclass.interpretePattern;

/**
 * 应用场景：
 * AndroidManifest.xml 与 PackageParser 的实现对清单文件所有标签的解析
 * Created by hp on 2020/3/31.
 */
public class TestMain {
    public static void main(String[] args) {
        //10-2+8
        System.out.println("result=" + new Plus().interpret(new Context(new Minus().interpret(new Context(10, 2)), 8)));
    }
}
