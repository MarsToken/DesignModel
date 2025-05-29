package com.example.designmodel.leetcode.listnode;

/**
 * 21.合并两个有序链表
 */
public class 合并两个有序链表21 {
    private static final String TAG = "M2Merge";

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 双指针：一个走，一个不走
        ListNode preHead = new ListNode(0);
        // 注意引入中间变量，否则 preHead就被设置到尾部了！
        ListNode head = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        head.next = list1 == null ? list2 : list1;
        // 注意返回初始指针，否则 preHead就被设置到尾部了！
        return preHead.next;
    }
}
