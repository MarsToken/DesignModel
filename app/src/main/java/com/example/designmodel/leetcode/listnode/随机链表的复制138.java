package com.example.designmodel.leetcode.listnode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class 随机链表的复制138 {
    private static final String TAG = "随机链表的复制138";

    Map<Node, Node> cachedNode = new HashMap<>();

    // 回溯 + 哈希表
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            // 节点可能还没创建
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
