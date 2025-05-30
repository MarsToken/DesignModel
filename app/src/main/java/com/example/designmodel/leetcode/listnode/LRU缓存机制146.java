package com.example.designmodel.leetcode.listnode;

import java.util.HashMap;

public class LRU缓存机制146 {
    private static final String TAG = "LRU缓存机制";

    class LRUCache {
        private int size;
        private int capacity;
        private DLinkNode head;
        private DLinkNode tail;
        private HashMap<Integer, DLinkNode> map = new HashMap<>();

        class DLinkNode {
            public int key;
            public int value;
            public DLinkNode pre;
            public DLinkNode next;

            public DLinkNode() {

            }

            public DLinkNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            map.clear();
            head = new DLinkNode();
            tail = new DLinkNode();
            // node1
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DLinkNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        private void moveToHead(DLinkNode node) {
            removeNode(node);
            addToHead(node);
        }

        // node2
        private void addToHead(DLinkNode node) {
            // 改四个指针
            // 1 <->3
            // 1 <- 2 -> 3
            // 1 <-> 2 <-> 3
            node.pre = head;
            node.next = head.next;
            // 特别注意顺序！
            head.next.pre = node;
            head.next = node;
        }

        // node3
        private void removeNode(DLinkNode node) {
            // 改两个指针
            // 1 <-> 2 <-> 3
            // 1 <->3
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void put(int key, int value) {
            DLinkNode node = map.get(key);
            if (node == null) {
                DLinkNode temp = new DLinkNode(key, value);
                map.put(key, temp);
                addToHead(temp);
                size++;
                if (size > capacity) {
                    DLinkNode tail = removeTail();
                    map.remove(tail.key);
                    size--;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private DLinkNode removeTail() {
            DLinkNode tail = this.tail.pre;
            removeNode(tail);
            return tail;
        }
    }
}
