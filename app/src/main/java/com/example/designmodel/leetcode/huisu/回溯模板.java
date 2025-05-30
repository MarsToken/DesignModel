package com.example.designmodel.leetcode.huisu;

import com.example.designmodel.leetcode.listnode.ListNode;

/**
 *
 */
public class 回溯模板 {
    private static final String TAG = "回溯模板";

    public static void main(String[] args) {
        ListNode header = new ListNode(1);
        ListNode temp = header;
        for (int i = 2; i < 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        header = reverseList2(header);
        while (header != null) {
            System.out.println(header.val);
            header = header.next;
        }
    }

    // 类似栈先进后出原理
    // 链表反转。
    public static ListNode reverseList2(ListNode head) { // 1->2->3->4
        // 边界判断，head为null是容错，head.next为null为真正判断
        if (head == null || head.next == null) {
            System.out.println("null");
            if (head != null) {
                System.out.println("null:" + head.val);
            }
            return head;
        }
        System.out.println("递归 head.value:" + head.val);
        // 递归
        ListNode newHead = reverseList2(head.next);
        System.out.println("回溯 head.value:" + head.val);
        System.out.println("回溯：newHead:" + newHead.val);
        // 回溯
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // 类似栈先进后出原理
    // 链表反转。
    public static ListNode reverseList(ListNode head) {
        // 边界判断 执行流程2
        if (head == null || head.next == null) {
            return head;
        }
        // 递归 执行流程1
        ListNode newHead = reverseList2(head.next);
        // 回溯 执行流程3
        head.next.next = head;
        head.next = null;
        return newHead; // newHead始终为4，即最后一个元素，它是边界条件返回的。
    }

    public static ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList4(head.next);
        newHead.next.next = head;
        newHead.next = null;
        return head;
    }
}
