package com.example.designmodel.rank;

import android.view.LayoutInflater;

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
        int limitIndex = partition(array, start, end);
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
        int limitIndex = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[end] >= array[i]) {
                limitIndex++;
                if (i > limitIndex) {
                    swap(array, limitIndex, i);
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
        if (length < 2) {
            return array;
        }
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

    private static void shellSort() {
        int length = array.length, mid = 0;
        do {
            mid = length / 2;
            for (int i = mid; i < length - 1; i++) {
                int temp = i + 1;
                for (int j = 0; j < temp; j++) {
                    if (array[temp] < array[j]) {
                        array[temp] += array[j];
                        array[j] = array[temp] - array[j];
                        array[temp] = array[temp] - array[j];
                    }
                }
            }
        } while (mid <= 0);
    }

    private static void insertSort() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int temp = i + 1;
            for (int j = 0; j < temp; j++) {
                if (array[temp] < array[j]) {
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
