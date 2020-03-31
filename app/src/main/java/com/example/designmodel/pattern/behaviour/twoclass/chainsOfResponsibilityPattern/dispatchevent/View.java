package com.example.designmodel.pattern.behaviour.twoclass.chainsOfResponsibilityPattern.dispatchevent;

/**
 * Created by hp on 2020/3/31.
 */
public interface View {
    boolean onDispatchTouchEvent();

    boolean onTouchEvent();

    boolean onInterceptTouchEvent();
}
