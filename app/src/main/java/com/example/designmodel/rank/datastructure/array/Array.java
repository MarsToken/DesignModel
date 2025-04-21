package com.example.designmodel.rank.datastructure.array;

/**
 * 注意添加index均后移一位
 * <p>
 * Created by WangMaoBo.
 * Date: 2025/4/19
 */
public class Array {
    private static final String TAG = "Array";
    private int[] array;

    public static void main(String[] args) {
        Array array = new Array(10);
//        array.insert(5, 3);
        System.out.println(array.getValue(3));
        System.out.println(array.findIndex(5));
//        array.remove(7);
        array.extend(5);
        array.traverse();
    }

    public Array(int length) {
        array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
    }

    public void extend(int enlarge) {
        int[] res = new int[array.length + enlarge];
        for (int i = 0; i < array.length; i++) {
            res[i] = array[i];
        }
        array = res;
    }

    public void remove(int index) {
        if (index < 0 || index > array.length - 1) {
            throw new IndexOutOfBoundsException("index is " + index + ",length is " + array.length);
        }
        for (int i = index; i < this.array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        // 1
        array[array.length - 1] = 0;
    }

    public int findIndex(int target) {
        for (int i = 0; i < this.array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int getValue(int index) {
        if (index < 0 || index > array.length - 1) {
            throw new IndexOutOfBoundsException("index is " + index + ",length is " + array.length);
        }
        return this.array[index];
    }

    public void insert(int num, int index) {
        if (index < 0 || index > array.length - 1) {
            throw new IndexOutOfBoundsException("index is " + index + ",length is " + array.length);
        }
        // 2
        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = num;
    }

    public void traverse() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
