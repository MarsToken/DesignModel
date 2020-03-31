package com.example.designmodel.pattern.behaviour.classstatus.memoryPattern;

/**
 * Created by hp on 2020/3/31.
 */
public class Original {
    private String value;

    public Original(String value) {
        this.value = value;
    }

    public String getValue() {
        return value == null ? "" : value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Memo createMemo() {
        return new Memo(value);
    }

    /**
     * 恢复状态
     *
     * @param memo
     */
    public void restoreMemo(Memo memo) {
        this.value = memo.getValue();
    }
}
