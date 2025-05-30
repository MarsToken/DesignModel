package com.example.designmodel.leetcode.listnode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Test {
    private static final String TAG = "Test";

    class LRUCache {
        private Map<Integer, DLinkNode> cache = new HashMap<>();
        private int size = 0;
        private int capacity = 0;
        private DLinkNode head;
        private DLinkNode tail;

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
            this.capacity = capacity;
            this.size = 0;
            cache.clear();
            head = new DLinkNode();
            tail = new DLinkNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DLinkNode node = cache.get(key);
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

        private void addToHead(DLinkNode node) {
            // 1 <->3
            // 1 <- 2 -> 3
            // 1 <-> 2 <-> 3
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        private void removeNode(DLinkNode node) {
            // 1 <-> 2 <-> 3
            // 1 <->3
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }


        public void put(int key, int value) {
            DLinkNode node = cache.get(key);
            if (node == null) {
                DLinkNode newHead = new DLinkNode(key, value);
                cache.put(key, newHead);
                addToHead(newHead);
                size++;
                if (size > capacity) {
                    DLinkNode tail = removeTail();
                    cache.remove(tail.key);
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
