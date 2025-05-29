package com.example.designmodel.leetcode.listnode;

/**
 * 1.新增

 ListNode head = new ListNode(0);
 // 如果 head作为返回值，则不能破坏head的游标，需要用temp完成后续next的搭建
 ListNode temp = head
 ListNode cur = new ListNode(element);
 // 新增第一步：首先给temp.next赋值
 temp.next = cur;
 // 新增第二步：再改变temp的指向，即往前走一步
 temp = temp.next;
 return head.next;

 套路：一步一脚印

 */
public class 链表套路 {
    private static final String TAG = "链表套路";

}
