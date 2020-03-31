package com.example.designmodel.pattern.behaviour.twoclass.iteratorPattern;

/**
 * Created by hp on 2020/3/30.
 */
public class ConcreteIterator implements Iterator {
    private Collection mCollection;
    private int mCurrentPos = -1;

    public ConcreteIterator(Collection collection) {
        mCollection = collection;
    }

    @Override
    public Object previous() {
        if (mCurrentPos > 0) {
            mCurrentPos--;
        }
        return mCollection.get(mCurrentPos);
    }

    @Override
    public Object next() {
        if (mCurrentPos < mCollection.size() - 1) {
            mCurrentPos++;
        }
        return mCollection.get(mCurrentPos);
    }

    @Override
    public boolean hasNext() {
        return mCurrentPos < mCollection.size() - 1;
    }

    @Override
    public Object first() {
        mCurrentPos = 0;
        return mCollection.get(mCurrentPos);
    }
}
