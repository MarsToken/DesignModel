package com.example.designmodel.pattern.structure.ProxyPattern.dynamicPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hp on 2020/6/29.
 */
public class DynamicProxy implements InvocationHandler {
    private Object mTarget;

    public void setTarget(Object target) {
        mTarget = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        Object object = method.invoke(mTarget, args);
        return object;
    }
}
