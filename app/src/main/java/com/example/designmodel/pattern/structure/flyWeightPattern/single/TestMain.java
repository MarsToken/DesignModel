package com.example.designmodel.pattern.structure.flyWeightPattern.single;

/**
 * 通过内蕴（唯一）获取对象，通过外蕴改变状态
 *
 * 万能适配器封装，ViewHolder里View的复用就是此模式
 * 内蕴实际就是View自身，一般是view的id，外蕴是数据，我们复用View，但是展示不同的数据
 * Created by hp on 2020/3/21.
 */
public class TestMain {
    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();
        FlyWeight fly = factory.product(new Character('a'));//内蕴
        fly.operation("First Call");//外蕴
        fly = factory.product(new Character('b'));
        fly.operation("Second Call");
        //通过log发现此fly复用的内蕴为'a'的对象，仅仅改变的外蕴
        fly = factory.product(new Character('a'));
        fly.operation("Third Call");
        System.out.println("size=" + factory.getFileSize());
    }
}
