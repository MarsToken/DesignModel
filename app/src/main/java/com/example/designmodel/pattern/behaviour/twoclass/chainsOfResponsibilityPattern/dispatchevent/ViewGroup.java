package com.example.designmodel.pattern.behaviour.twoclass.chainsOfResponsibilityPattern.dispatchevent;


/**
 * Created by hp on 2020/3/31.
 */
public class ViewGroup extends AbstractView {
    private String name;

    public ViewGroup(String name) {
        this.name = name;
    }

    @Override
    public boolean onDispatchTouchEvent() {
        if (onInterceptTouchEvent()) {
            System.out.println(name + " onDispatchTouchEvent has resolved this event!");
            onTouchEvent();
        } else {
            System.out.println(name + " onDispatchTouchEvent has not resolved this event!");
            if (null != getChild()) {
                getChild().onDispatchTouchEvent();
            } else {
                System.out.println("I am employee,can not dispatch");
                getParent().onTouchEvent();
            }
        }
        return isDispatch;
    }

    @Override
    public boolean onTouchEvent() {
        System.out.println(name + " onTouchEvent " + !isDispatch);
        if (getChild() != null && ((AbstractView) getChild()).isDispatch()) {
            if (null != getParent()) {
                getParent().onTouchEvent();
            } else {
                System.out.println(name + "only me resolve!!!");
                return true;
            }
        }
        return !isDispatch;
    }

    @Override
    public boolean onInterceptTouchEvent() {
        System.out.println(name + " onInterceptTouchEvent resolved this event!=" + !isDispatch);
        return !isDispatch;
    }

}
