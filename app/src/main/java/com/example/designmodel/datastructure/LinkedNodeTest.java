package com.example.designmodel.datastructure;

/**
 * 数据结构之链表
 * Created by hp on 2020/4/1.
 */
public class LinkedNodeTest {
    public static void main(String[] args) {
        LinkNode linkNode = new LinkNode();
        linkNode.insert(0, 1);
        linkNode.insert(1, 3);
        linkNode.insert(2, 4);
        linkNode.insert(3, 5);
        // linkNode.delete(1);
        linkNode.output();
        revertLink(linkNode);
    }

    private static void revertLink(LinkNode linkNode) {
        if(linkNode == null){
            return;
        }

    }

    /**
     * query 只能用一次，这涉及到时间复杂度度问题，所以不宜使用多次，导致效率降低
     * 核心，切断next线，改变头尾
     * 先操作链表，再操作内部
     */
    public static class LinkNode {
        private Node head;
        private Node last;
        private int size;

        /**
         * o(O)头部，尾部=1，中间=n/2
         *
         * @param index
         * @param value
         */
        public void insert(int index, int value) {
            if (index < 0 || index > size) {//易错点！此处是>size
                throwIndexOutOfBoundsException();
            }
            Node insertNode = new Node(value);
            if (size == 0) {
                head = insertNode;
                last = insertNode;
            } else if (index == 0) {
                insertNode.next = head;
                head = insertNode;
            } else if (index == size) {//易错点！此处是>size
                last.next = insertNode;
                last = insertNode;
            } else {//链表查询只调用一次
                Node preNode = query(index - 1);
                insertNode.next = preNode.next;
                preNode.next = insertNode;
            }
            size++;
        }

        public void delete(int index) {
            if (index < 0 || index >= size) {//易错点！此处是>=size
                throwIndexOutOfBoundsException();
            }
            if (index == 0) {
                Node deleteNode = head;
                head = deleteNode.next;
            } else if (index == size - 1) {
                Node pre = query(index - 1);//注意Node pre = size-2;如果size=1，则index只能=0，故走index==0的逻辑
                pre.next = null;
                last = pre;
            } else {
                Node pre = query(index - 1);
                //Node next = query(index + 1);
                Node next = pre.next.next;
                pre.next = next;
            }
            size--;
        }

        public Node query(int index) {
            if (index < 0 || index > size) {
                throwIndexOutOfBoundsException();
            }
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public void output() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
        }

        private void throwIndexOutOfBoundsException() {
            throw new IndexOutOfBoundsException();
        }
    }

    public static class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
