package com.example.designmodel.rank.datastructure.queue;

import com.example.designmodel.rank.datastructure.list.DynamicArrayList;

import java.util.ArrayList;

/**
 * 两种实现方式，动态数组ArrayList和int[]数组
 * 核心api，push,peek,pop
 * Created by WangMaoBo.
 * Date: 2025/4/21
 */
public class ArrayQueue {
    private static final String TAG = "ArrayQueue";
    private DynamicArrayList numbers;

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue();
        for (int i = 0; i < 5; i++) {
            arrayQueue.push(i);
        }
        int top = arrayQueue.peek();
        System.out.println("top is " + top);
        int removeTop = arrayQueue.pop();
        System.out.println("remove top is " + removeTop);
        int[] res = arrayQueue.toArray();
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ",");
        }
    }

    public ArrayQueue() {
        numbers = new DynamicArrayList();
    }

    public int size() {
        return numbers.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(int number) {
        numbers.add(number);
    }

    public Integer peek() {
        if (size() == 0) {
            return null;
        }
        return numbers.get(0);
    }

    public Integer pop() {
        if (size() == 0) {
            return null;
        }
        return numbers.remove(0);
    }

    public int[] toArray() {
        return numbers.toArray();
    }


}
