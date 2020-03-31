package com.example.designmodel.pattern.behaviour.twoclass.chainsOfResponsibilityPattern.dispatchevent;

/**
 * Created by hp on 2020/3/31.
 */
public abstract class AbstractView implements View {
    private View parent;
    private View child;
    protected boolean isDispatch = true;

    public boolean isDispatch() {
        return isDispatch;
    }

    public void setDispatch(boolean dispatch) {
        isDispatch = dispatch;
    }


    public void setParent(View view) {
        this.parent = view;
    }

    public View getParent() {
        return parent;
    }

    public View getChild() {
        return child;
    }

    public void setChild(View child) {
        this.child = child;
    }
}
