package com.example.designmodel.rank.datastructure;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/23
 */

public class LinkNodeTest {
    public static void main(String[] args) {
        LinkNode head = new LinkNode(0);
//        LinkNode current = head;
//        int index = 1;
//        while (index < 10) {
//            LinkNode next = new LinkNode(index++);
//            current.next = next;
//            current = current.next;
//        }
        int index = 1;
        while (index < 10) {
            head.insert(new LinkNode(index++));
        }
        head.insert(head, new LinkNode(100));

        while (head != null) {
            System.out.println("value:" + head.value);
            head = head.next;
        }

//        LinkNode newHead = reverseList(head);
//        while (newHead != null) {
//            System.out.println("value:" + newHead.value);
//            newHead = newHead.next;
//        }
    }

    private static LinkNode reverseList(LinkNode head) {
        LinkNode pre = null;
        LinkNode current = head;
        LinkNode next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}

class LinkNode {
    private static final String TAG = "LinkNode";
    int value;
    LinkNode next;

    public LinkNode(int value) {
        this.value = value;
    }

    // 默认插到尾部
    public void insert(LinkNode current) {
        LinkNode currentLocal = this;
        LinkNode nextLocal = this.next;
        while (nextLocal != null) {
            currentLocal = nextLocal;
            nextLocal = nextLocal.next;
        }
        currentLocal.next = current;
    }

    /* 在链表的节点 pre 之后插入节点 p */
    public void insert(LinkNode pre, LinkNode p) {
        LinkNode temp = pre.next;
        p.next = temp;
        pre.next = p;
    }

    /* 删除链表的节点 node 之后的首个节点 */
    public void delete(LinkNode node) {
        if (node == null || node.next == null) {
            return;
        }
        LinkNode next = node.next;
        LinkNode nextNext = next.next;
        node.next = nextNext;
    }

    public void visit(LinkNode head) {
        while (head != null) {
            System.out.println("value:" + head.value);
            head = head.next;
        }
    }

    /* 在链表中查找值为 target 的首个节点 */
    public int find(LinkNode head, int value) {
        int index = 0;
        while (head != null) {
            if (head.value == value) {
                return index;
            }
            head = head.next;
            index++;
        }
        return -1;
    }
}
