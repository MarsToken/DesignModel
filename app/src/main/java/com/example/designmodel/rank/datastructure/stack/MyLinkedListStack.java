package com.example.designmodel.rank.datastructure.stack;

import com.example.designmodel.rank.datastructure.LinkNode;

/**
 * 基于链表实现的栈
 *
 * @author WangMaoBo
 * @since 2025/4/21
 */
public class MyLinkedListStack {
    private static final String TAG = "MyStack";
    // 将头结点作为栈顶
    private LinkNode topStack;
    // 容量
    private int size = 0;

    public static void main(String[] args) {
        MyLinkedListStack stack = new MyLinkedListStack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println("栈顶元素：" + stack.peek());
        System.out.println("取出栈顶元素：" + stack.pop());
//        for (int i = 0; i < 5; i++) {
//            Integer pop = stack.pop();
//            if (null != pop) {
//                System.out.print(pop + ",");
//            }
//        }
        System.out.println("");
        int[] res = stack.toArray();
        for (int i = 0; i < res.length; i++) {
            System.out.print("res:" + res[i] + ",");
        }
    }

    public MyLinkedListStack() {
        topStack = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int number) {
        LinkNode currentNode = new LinkNode(number);
        currentNode.setNext(topStack);
        // 注意
        topStack = currentNode;
        size++;
    }

    public Integer pop() {
        Integer top = peek();
        if (top == null) {
            return null;
        }
        topStack = topStack.getNext();
        size--;
        return top;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return topStack.getValue();
    }

    public int[] toArray() {
        int[] res = new int[size];
        int index = 0;
        LinkNode node = topStack;
        while (node != null) {
            res[index++] = node.getValue();
            node = node.getNext();
        }
        return res;
    }


}
