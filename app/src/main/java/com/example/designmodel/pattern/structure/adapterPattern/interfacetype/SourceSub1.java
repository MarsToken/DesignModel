package com.example.designmodel.pattern.structure.adapterPattern.interfacetype;

/**
 * Created by hp on 2020/3/10.
 */
public class SourceSub1 extends Wrapper{
    @Override
    public void method1() {
        super.method1();
        System.out.println("this is sourceSub1 ,method1");
    }
}
