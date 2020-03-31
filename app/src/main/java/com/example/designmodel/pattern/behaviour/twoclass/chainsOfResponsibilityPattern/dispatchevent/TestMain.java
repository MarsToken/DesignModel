package com.example.designmodel.pattern.behaviour.twoclass.chainsOfResponsibilityPattern.dispatchevent;

/**
 * Created by hp on 2020/3/31.
 */
public class TestMain {
    public static void main(String[] args) {
        AbstractView boss = new ViewGroup("boss");
        AbstractView leader = new ViewGroup("leader");
        AbstractView employee = new ViewGroup("employee");

        boss.setChild(leader);
        leader.setChild(employee);
        leader.setParent(boss);
        employee.setParent(leader);

        boss.setDispatch(true);
        leader.setDispatch(true);
        employee.setDispatch(true);
        boss.onDispatchTouchEvent();
        /*
        *   boss onInterceptTouchEvent resolved this event!=false
            boss onDispatchTouchEvent has not resolved this event!
            leader onInterceptTouchEvent resolved this event!=false
            leader onDispatchTouchEvent has not resolved this event!
            employee onInterceptTouchEvent resolved this event!=false
            employee onDispatchTouchEvent has not resolved this event!
            I am employee,can not dispatch
            leader onTouchEvent false
            boss onTouchEvent false
        * */
    }
}
