package com.example.designmodel.rank.datastructure.list;

import java.util.Arrays;

/**
 * 列表（动态数组）的实现
 * 1.初始化
 * 2.增删改查
 * 3.可扩容
 * <p>
 * 注意 remove和insert方法:插入需要倒序错位，删除需要正序错位
 *
 * @author WangMaoBo
 * @since 2025/4/21
 */
public class DynamicArrayList {
    private static final String TAG = "List";
    private int[] res;
    // 容量不一定有值  CAPACITY >= size
    private int capacity = 10;
    // 长度指有意义已经赋值的元素数量
    private int size = 0;
    // 每次扩容的基于CAPACITY的倍数
    private int FACTOR = 2;

    public static void main(String[] args) {
        DynamicArrayList list = new DynamicArrayList();
        System.out.println("list size is " + list.size);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.set(3, 30);
//        list.insert(3, 30);
        list.remove(0);
        System.out.println("list index=5,value=" + list.get(5));
        int[] res = list.toArray();
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

    public DynamicArrayList() {
        res = new int[capacity];
    }

    public int size() {
        return size;
    }

    public void add(int number) {
        if (size == capacity) {
            extendCapacity();
        }
        size++;
        res[size - 1] = number;
    }

    public void insert(int index, int number) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界：index is " + index);
        }
        for (int i = size - 1; i > index; i--) {
            res[i] = res[i - 1];
        }
        res[index] = number;
    }

    public void set(int index, int number) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界：index is " + index);
        }
        res[index] = number;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界：index is " + index);
        }
        for (int i = index; i < size - 1; i++) {
            res[i] = res[i + 1];
        }
        size--;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界：index is " + index);
        }
        return res[index];
    }

    private void extendCapacity() {
        res = Arrays.copyOf(res, capacity * FACTOR);
        capacity = res.length;
    }

    public int[] toArray() {
        int[] newArray = new int[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = res[i];
        }
        return newArray;
    }


}
