package com.example.designmodel.leetcode.listnode;

import java.util.ArrayList;
import java.util.List;

/**
 * 206.反转链表
 **/
public class 反转链表206 {
    private static final String TAG = "M1Revert";

    // 双指针插头法 ，将当前节点的next指针指向已准备好的前一个节点
    /**
     * 通过三个指针(pre/current/next)的迭代操作，逐个反转节点指向。
     * 每次循环将当前节点的next指向前驱节点，然后三个指针整体前移
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next; // 和a、b换值一个道理
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 递归 套路，万能模板
    public ListNode reverseList2(ListNode head) {
        // 边界判断
        if (head == null || head.next == null) {
            return head;
        }
        // 递归
        ListNode newHead = reverseList2(head.next);
        // 回溯
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    // 借助数组，空间复杂度n
    public static ListNode reverseList4(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            ListNode cur = new ListNode(head.val);
            list.add(cur);
            head = head.next;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).val + "==");
        }
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        for (int i = list.size() - 1; i >= 0; i--) {
            temp.next = list.get(i);
            temp = temp.next;
        }
        return newHead.next;
    }

    /**
     * 递归详解
     * <p>
     * 以链表1->2->3->4->5举例
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            /*
             * 直到当前节点的下一个节点为空时返回当前节点
             * 由于5没有下一个节点了，所以此处返回节点5
             *
             */
            return head;
        }
        //递归传入下一个节点，目的是为了到达最后一个节点
        ListNode newHead = reverseList3(head.next);
                /*
            第一轮出栈，head为5，head.next为空，返回5
            第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
                      把当前节点的子节点的子节点指向当前节点
                      此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
                      此时链表为1->2->3->4<-5
                      返回节点5
            第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
                      此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
                      此时链表为1->2->3<-4<-5
                      返回节点5
            第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
                      此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
                      此时链表为1->2<-3<-4<-5
                      返回节点5
            第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
                      此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
                      此时链表为1<-2<-3<-4<-5
                      返回节点5
            出栈完成，最终头节点5->4->3->2->1
         */
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
