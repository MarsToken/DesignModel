package com.example.designmodel.rank;

import java.util.Arrays;

/**
 * Created by hp on 2020/2/10.
 */
public class TestRank {
    public static int[] array = new int[]{123, 4, 55, 3111, 334, 6, 2, 1};

    public static void main(String[] args) {
        //bubbleRank();
        //selectRank();
        //insertSort();
        //shellSort();
        //int[] array = mergeSort(TestRank.array);
        //quickSort(array, 0, array.length - 1);
        heapSort();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    private static void heapSort() {


    }

    private static void quickSort(int[] array, int start, int end) {
        int length = array.length;
        if (start < 0 || end >= length || start > end || length == 0) return;
        int limitIndex = partition(array, start, end);//确定基准，limitIndex为比基准小的总数的索引+1（即基准的索引）
        if (start < limitIndex) {
            quickSort(array, start, limitIndex - 1);
        }
        if (limitIndex < end) {
            quickSort(array, limitIndex + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = (int) ((end - start + 1) * Math.random() + start);
        swap(array, pivot, end);
        int limitIndex = start - 1;//因为把基准放到了最右侧
        for (int i = start; i <= end; i++) {
            if (array[end] >= array[i]) {
                limitIndex++;
                if (i > limitIndex) {
                    swap(array, limitIndex, i);//互换的是为了保证中间值左边都比他小，右边都比他大
                }
            }
        }
        return limitIndex;
    }

    private static void swap(int[] array, int pivot, int end) {
        if (pivot == end) return;
        array[pivot] += array[end];
        array[end] = array[pivot] - array[end];
        array[pivot] = array[pivot] - array[end];
    }

    private static int[] mergeSort(int[] array) {
        int length = array.length;
        if (length < 2) return array;
        int mid = length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, length);
        return merge(mergeSort(left), mergeSort(right));

    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int i = 0, left_index = 0, right_index = 0; i < result.length; i++) {
            if (left_index >= left.length) {
                result[i] = right[right_index++];
            } else if (right_index >= right.length) {
                result[i] = left[left_index++];
            } else if (left[left_index] > right[right_index]) {
                result[i] = right[right_index++];
            } else {
                result[i] = left[left_index++];
            }
        }
        return result;
    }

    private static void shellRank2() {
        int length = array.length, mid = 0;
        do {
            mid = length / 2;
            for (int i = mid; i < length - 1; i++) {
                int current = array[i + 1];
                int j = i;
                while (j >= 0 && array[j] > current) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = current;
            }
        } while (mid == 0);

    }

    private static void shellSort() {
        int length = array.length, mid = 0;
        do {
            mid = length / 2;
            for (int i = mid; i < length - 1; i++) {
                int temp = i + 1;
                for (int j = 0; j < temp; j++) {
                    if (array[temp] < array[j]) {//由于序列是排好的，所以理论上只会走一次
                        array[temp] += array[j];
                        array[j] = array[temp] - array[j];
                        array[temp] = array[temp] - array[j];
                    }
                }
            }
        } while (mid <= 0);
    }

    private static void insertRank2() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int j = i;
            int current = array[i + 1];
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    private static void insertSort() {//非主流，实际上还是特殊的选择排序
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int temp = i + 1;
            for (int j = 0; j < temp; j++) {
                if (array[temp] < array[j]) {//由于序列是排好的，所以理论上只会走一次
                    array[temp] += array[j];
                    array[j] = array[temp] - array[j];
                    array[temp] = array[temp] - array[j];
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

    private static void bubbleRank() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] += array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
        }
    }

}
