package com.example.designmodel.pattern.behaviour.thirdclass.visitorPattern;

/**
 * Created by hp on 2020/3/31.
 */
public interface Subject {
    /**
     * 招待方法
     *
     * @param visitor 参观者
     */
    void accept(Visitor visitor);

    /**
     * 暴露给参观者的值
     *
     * @return
     */
    String getValue();
}
