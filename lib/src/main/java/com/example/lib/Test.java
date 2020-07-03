package com.example.lib;

import java.util.Arrays;

/**
 * Created by hp on 2020/5/28.
 */
public class Test {
    public static int[] array = new int[]{123, 4, 55, 3111, 334, 6, 2, 1};
    public static void main(String[] args) {
        System.out.println("test");
        //bubbleSort();
        //selectRank();
        //insertRank();
        //shellRank();
        array = mergeSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static int[] mergeSort(int[] array) {
        if(array==null) return null;
        int length = array.length;
        if(length<2) return array;
        int mid = length / 2;
        int left[] = Arrays.copyOfRange(array, 0, mid);
        int right[] = Arrays.copyOfRange(array, mid, length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int result[] = new int[left.length + right.length];
        for (int index = 0, left_index = 0, right_index = 0; index < result.length; index++) {
            if (left.length <= left_index) {
                result[index] = right[right_index++];
            } else if (right.length <= right_index) {
                result[index] = left[left_index++];
            } else if (left[left_index] > right[right_index]) {
                result[index] = right[right_index++];
            }else{
                result[index] = left[left_index++];
            }
        }
        return result;
    }

    private static void shellRank() {
        int length = array.length, gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i < length - 1; i++) {
                int temp_index = i + 1;
                for (int j = 0; j < temp_index; j++) {
                    if (array[temp_index] < array[j]) {
                        array[temp_index] += array[j];
                        array[j] = array[temp_index] - array[j];
                        array[temp_index] = array[temp_index] - array[j];
                    }
                }
            }
            gap /= 2;
        }
    }
    private static void insertRank() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int temp_index = i + 1;
            for (int j = 0; j < temp_index; j++) {
                if (array[j] > array[temp_index]) {
                    array[j] += array[temp_index];
                    array[temp_index] = array[j] - array[temp_index];
                    array[j]=array[j] - array[temp_index];
                }
            }
        }
    }

    private static void selectRank() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    array[i] += array[j];
                    array[j] = array[i] - array[j];
                    array[i] = array[i] - array[j];
                }
            }
        }
    }
    private static void bubbleSort() {
        if (null == array) return;
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] += array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
        }
    }

}
