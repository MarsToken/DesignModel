package com.example.designmodel.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 求二叉树最大宽度
 */
public class 填充每个节点的下一个右侧节点指针II117 {
    private static final String TAG = "填充每个节点的下一个右侧节点指针II";

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node last = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i != 0) {
                    last.next = node;
                }
                last = node;

            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
