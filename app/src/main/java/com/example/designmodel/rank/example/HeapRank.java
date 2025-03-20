package com.example.designmodel.rank.example;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/20
 */
public class HeapRank {
    private static final String TAG = "HeapRank";

    public static void main(String[] args) {
        int[] array = Constant.array;
        if (null == array) {
            return;
        }
        int length = array.length;
        heapSort(array);
        for (int i = 0; i < length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    private static void heapSort(int[] array) {
        // 建堆操作：堆化除叶节点以外的其他所有节点 array.length / 2 - 1 表示最后一个非叶子节点
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            siftDown(array, array.length, i);
        }
        // 从堆中提取最大元素，循环 n-1 轮
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            siftDown(array, i, 0);
        }
    }

    /* 堆的长度为 length ，从节点 i 开始，从顶至底堆化 */
    private static void siftDown(int[] array, int length, int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int mid = i;
            if (left < length && array[left] > array[mid]) {
                mid = left;
            }
            if (right < length && array[right] > array[mid]) {
                mid = right;
            }
            if (mid == i) {
                break;
            }
            int temp = array[i];
            array[i] = array[mid];
            array[mid] = temp;
            i = mid;
        }
    }
}
