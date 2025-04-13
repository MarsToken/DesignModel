package com.example.designmodel.rank.example;

import java.util.Arrays;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/6
 */
public class Practice {
    private static final String TAG = "Practice";

    public static void main(String[] args) {
        int[] array = Constant.array;
        if (null == array) {
            return;
        }
        int length = array.length;
        heapRank(array);
        for (int i = 0; i < length; i++) {
            System.out.println(array[i] + " ");
        }

    }

    private static void heapRank(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            siftDown(array, array.length, i);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            siftDown(array, i, 0);
        }
    }

    private static void siftDown(int[] array, int length, int i) {
        while (true) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
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
            int temp = array[mid];
            array[mid] = array[i];
            array[i] = temp;
            i = mid;
        }
    }


}
