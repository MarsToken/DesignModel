package com.example.designmodel.datastructure;

/**
 * Created by hp on 2020/4/1.
 */
public class Test {
    public static void main(String[] args) {
        LinkedNode linkNode = new LinkedNode();
        linkNode.insert(0, 1);
        linkNode.insert(1, 3);
        linkNode.insert(2, 4);
        linkNode.insert(3, 5);
        linkNode.delete(2);
        linkNode.output();
    }

    public static class LinkedNode {
        public Node head;
        public Node last;
        public int size;


        private void throwOutOfBoundsException() {
            throw new IndexOutOfBoundsException();
        }

        public void insert(int index, int value) {
            if (index < 0 || index > size) {
                throwOutOfBoundsException();
            }
            Node insertNode = new Node(value);
            if (size == 0) {
                head = insertNode;
                last = insertNode;
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
            if (index < 0 || index > size - 1) {
                throwOutOfBoundsException();
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
            if (index < 0 || index > size - 1) {
                throwOutOfBoundsException();
            }
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public void output() {
            Node node = head;
            while (node != null) {
                System.out.println(node.value);
                node = node.next;
            }
        }
    }


    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


}
