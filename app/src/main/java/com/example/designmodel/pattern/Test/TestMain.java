package com.example.designmodel.pattern.Test;

/**
 * Created by hp on 2020/3/12.
 */
public class TestMain {
    public static void main(String[] args) {
        HurmBug chineseHurmbug = new ChineseHurmbug();
        Builder builder = new HurmBugBuilder(chineseHurmbug);
        Director director = new Director(builder);
        director.build("汉堡","西蓝花");
        System.out.println(chineseHurmbug.toString());
    }
}
