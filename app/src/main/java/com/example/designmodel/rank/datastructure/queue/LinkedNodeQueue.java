package com.example.designmodel.rank.datastructure.queue;

import com.example.designmodel.rank.datastructure.bean.LinkNode;

/**
 * 由于队列是先进先出，所以插入（push）的时候插到尾部
 * 核心api，push,peek,pop
 *
 * Created by WangMaoBo.
 * Date: 2025/4/21
 */
public class LinkedNodeQueue {
    private static final String TAG = "LinkedNodeQueue";
    // 头结点，为节点
    private LinkNode head, tail;
    private int size;

    public static void main(String[] args) {
        LinkedNodeQueue queue = new LinkedNodeQueue();
        for (int i = 0; i < 5; i++) {
            queue.push(i);
        }
        int top = queue.peek();
        System.out.println("top is " + top);
        int removeTop = queue.pop();
        System.out.println("removeTop is " + removeTop);
        int[] res = queue.toArray();
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ",");
        }
    }

    public LinkedNodeQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(int number) {
        LinkNode node = new LinkNode(number);
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public Integer pop() {
        int number = peek();
        head = head.getNext();
        size--;
        return number;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return head.getValue();
    }

    public int[] toArray() {
        int[] res = new int[size];
        int index = 0;
        LinkNode temp = head;
        while (temp != null) {
            res[index++] = temp.getValue();
            temp = temp.getNext();
        }
        return res;
    }
}
