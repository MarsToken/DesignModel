package com.example.designmodel.rank.datastructure;

/**
 * 单链表
 *
 * @author WangMaoBo
 * @since 2025/4/21
 */
public class LinkNode {
    private static final String TAG = "LinkNode";
    private int value;
    private LinkNode next;

    public LinkNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}
