package com.example.designmodel.leetcode.listnode;

/**
 * while (result != 0) {
 *   int element = result % 10;
 *   result = result / 10;
 * }
 */
public class 两数相加2 {
    private static final String TAG = "两数相加2";

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int number1 = 0, number2 = 0;
        int count1 = 1;
        while (l1 != null) {
            number1 += (l1.val * count1);
            count1 *= 10;
            l1 = l1.next;
        }
        int count2 = 1;
        while (l2 != null) {
            number2 += (l2.val * count2);
            count2 *= 10;
            l2 = l2.next;
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int result = number1 + number2;
        // 边界判断
        if (result == 0) {
            return head;
        }
        while (result != 0) {
            int element = result % 10;
            result = result / 10;
            ListNode cur = new ListNode(element);
            // 给当前temp.next赋新值
            temp.next = cur;
            // 将next赋值给temp
            temp = temp.next;
        }
        return head.next;
    }

}
