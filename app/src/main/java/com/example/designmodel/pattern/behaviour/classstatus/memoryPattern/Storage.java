package com.example.designmodel.pattern.behaviour.classstatus.memoryPattern;

/**
 * 只存储Memo，不能进行修改等其他操作
 * Created by hp on 2020/3/31.
 */
public class Storage {
    private Memo memo;

    public Storage(Memo memo) {
        this.memo = memo;
    }

    public Memo getMemo() {
        return memo;
    }

    public void setMemo(Memo memo) {
        this.memo = memo;
    }
}
