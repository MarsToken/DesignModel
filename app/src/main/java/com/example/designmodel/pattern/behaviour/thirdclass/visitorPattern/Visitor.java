package com.example.designmodel.pattern.behaviour.thirdclass.visitorPattern;

/**
 * 客人-算法模型
 *
 * Created by hp on 2020/3/31.
 */
public interface Visitor {
    /**
     * 参观方法
     *
     * @param subject 被参观对象
     */
    void visit(Subject subject);
}
