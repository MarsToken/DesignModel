package com.example.designmodel.leetcode.listnode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1.双指针（快慢指针）
 */
public class 环形链表141 {
    private static final String TAG = "环形链表141";

    // hash表
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    // 快慢指针

    /**
     * 本方法需要读者对「Floyd 判圈算法」（又称龟兔赛跑算法）有所了解。
     * <p>
     * 假想「乌龟」和「兔子」在链表上移动，「兔子」跑得快，「乌龟」跑得慢。
     * 当「乌龟」和「兔子」从链表上的同一个节点开始移动时，如果该链表中没有环，
     * 那么「兔子」将一直处于「乌龟」的前方；如果该链表中有环，那么「兔子」会先于「乌龟」进入环，
     * 并且一直在环内移动。等到「乌龟」进入环时，由于「兔子」的速度快，它一定会在某个时刻与乌龟相遇，
     * 即套了「乌龟」若干圈
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next; // 如果我们将两个指针初始都置于 head，那么 while 循环就不会执行
        while (fast == null || fast.next == null) { // 判断是否走完，走完了还没有相遇则无环
            slow = slow.next;
            fast = fast.next.next;
            if (slow != fast) { // 相等则有换 返回为true
                return true;
            }
        }

        return true;
    }

    // 找中间节点（偶数长度返回靠左的中间节点）
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // slow即为中间节点
    }
}
