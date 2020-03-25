package com.example.designmodel.pattern.structure.bridgePattern;

/**
 * Created by hp on 2020/3/13.
 */
public class Bridge {
    private ISource mSource;

    public void setSource(ISource source) {
        mSource = source;
    }

    public ISource getSource() {
        return mSource;
    }

    public void method() {
        mSource.method();
    }
}
