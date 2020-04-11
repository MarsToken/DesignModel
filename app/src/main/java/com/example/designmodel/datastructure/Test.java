package com.example.designmodel.datastructure;

/**
 * Created by hp on 2020/4/1.
 */
public class Test {
    public static void main(String[] args) {
        LinkNode linkNode = new LinkNode();
        linkNode.insert(0, "1");
        linkNode.insert(1, "3");
        linkNode.insert(2, "4");
        linkNode.insert(3, "5");
        //linkNode.delete(1);
        linkNode.outPut();
    }

    public static class LinkNode {
        public Node head;
        public Node last;
        public int size;

        public void insert(int index, String value) {
            if (index < 0 || index > size) {
                throwIndexOutOfBoundsException();
            }
            Node insertNode = new Node(value);
            if (size == 0) {
                head = insertNode;
                last = head;
            } else if (index == 0) {
                insertNode.next = head;
                head = insertNode;
            } else if (index == size) {
                last.next = insertNode;
                last = insertNode;
            } else {
                Node pre = query(index - 1);
                insertNode.next = pre.next;
                pre.next = insertNode;
            }
            size++;
        }

        public void delete(int index) {
            if (index < 0 || index >= size) {
                throwIndexOutOfBoundsException();
            }
            if (index == 0) {
                head = head.next;
            } else if (index == size - 1) {
                Node pre = query(index - 1);
                pre.next = null;
                last = pre;
            } else {
                Node pre = query(index - 1);
                pre.next = pre.next.next;

            }
            size--;
        }

        public Node query(int index) {
            if (index < 0 || index > size) {
                throwIndexOutOfBoundsException();
            }
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        public void outPut() {
            Node node = head;
            while (node.next != null) {
                System.out.println(node.value);
                node = node.next;
            }
        }

        private void throwIndexOutOfBoundsException() {
            throw new IndexOutOfBoundsException();
        }

    }

    public static class Node {
        public String value;
        public Node next;

        public Node(String value) {
            this.value = value;
        }
    }
}
