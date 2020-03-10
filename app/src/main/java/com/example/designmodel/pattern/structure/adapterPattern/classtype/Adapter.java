package com.example.designmodel.pattern.structure.adapterPattern.classtype;

/**
 * Created by hp on 2020/3/10.
 */
public class Adapter extends Source implements Targetable{
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
