package com.example.designmodel.rank.datastructure.array;

/**
 * Created by WangMaoBo.
 * Date: 2025/4/19
 */
public class ListNode {
    private static final String TAG = "ListNode";

    public static void main(String[] args) {
        // init
        Node root = new Node(0);
//        for (int i = 0; i < 5; i++) {
//            root.next = new Node(i);
//            root = root.next;
//        }
        root.insert(root, new Node(1));
        root.insert(root.next, new Node(2));
        root.insert(root.next.next, new Node(3));
        root.insert(root.next.next.next, new Node(4));
        root.insert(root.next.next.next.next, new Node(5));
        root.remove(root.next);
        Node accessNode = root.access(root, 2);
        System.out.println("访问索引2的值为：" + accessNode.value);
        int findIndex = root.find(root, 4);
        System.out.println("目标值为4的索引:" + findIndex);
        while (root != null) {
            System.out.println(root.value);
            root = root.next;
        }
    }

    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        /* 在链表中查找值为 target 的首个节点，返回其索引 */
        public int find(Node head, int target) {
            int index = -1;
            while (head != null) {
                index++;
                if (head.value == target) {
                    return index;
                }
                head = head.next;
            }
            return -1;
        }

        /* 访问链表中索引为 index 的节点 */
        public Node access(Node head, int index) {
            for (int i = 0; i < index; i++) {
                if (head == null) {
                    return null;
                }
                head = head.next;
            }
            return head;
        }

        // node->b->c
        // node->c
        /* 删除链表的节点 node 之后的首个节点 */
        public void remove(Node node) {
            if (node == null) {
                return;
            }
            node.next = node.next.next;
        }

        // a->c
        // b->c a->b->c
        // 建议先处理下游，再处理上游
        public void insert(Node pre, Node target) {
            target.next = pre.next;
            pre.next = target;
        }

        // a->c
        // a->b a->b->c
        public void insert2(Node pre, Node target) {
            pre.next = target;
            target.next = pre.next.next;
        }
    }
}
