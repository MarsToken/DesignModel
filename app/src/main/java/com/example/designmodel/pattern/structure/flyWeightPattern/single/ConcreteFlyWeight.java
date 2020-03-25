package com.example.designmodel.pattern.structure.flyWeightPattern.single;

/**
 * 具体享元角色类
 * Created by hp on 2020/3/21.
 */
public class ConcreteFlyWeight implements FlyWeight {
    private Character intrinsicState = null;

    /**
     * 构造函数，内蕴状态作为参数传入
     */
    public ConcreteFlyWeight(Character character) {
        this.intrinsicState = character;
    }

    /**
     * 外蕴状态作为参数传入方法中，改变方法的行为，
     * 但是并不改变对象的内蕴状态。
     */
    @Override
    public void operation(String status) {
        System.out.println("Intrinsic State = " + this.intrinsicState);
        System.out.println("Extrinsic State = " + status);
    }
}
