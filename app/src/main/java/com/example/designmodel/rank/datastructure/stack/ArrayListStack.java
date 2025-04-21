package com.example.designmodel.rank.datastructure.stack;

import com.example.designmodel.rank.datastructure.list.DynamicArrayList;

/**
 * 基于数组实现的栈
 *
 * @author WangMaoBo
 * @since 2025/4/21
 */
public class ArrayListStack {
    private static final String TAG = "MyArrayListStack";
    private DynamicArrayList stack;

    public static void main(String[] args) {
        ArrayListStack alStack = new ArrayListStack();
        for (int i = 0; i < 5; i++) {
            alStack.push(i);
        }
        System.out.println("stack size is " + alStack.size());
        int top = alStack.peek();
        System.out.println("top is " + top);
        int removeTop = alStack.pop();
        System.out.println("remove top is " + removeTop);
        for (Object o : alStack.toArray()) {
            System.out.println("o:" + o);
        }
    }

    public ArrayListStack() {
        stack = new DynamicArrayList();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(int number) {
        stack.add(number);
    }

    public Integer pop() {
        if (size() == 0) {
            return null;
        }
        return stack.remove(size() - 1);
    }

    public Integer peek() {
        if (size() == 0) {
            return null;
        }
        return stack.get(size() - 1);
    }

    public int[] toArray() {
        return stack.toArray();
    }
}
