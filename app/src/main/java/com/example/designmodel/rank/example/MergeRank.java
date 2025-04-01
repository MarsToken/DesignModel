package com.example.designmodel.rank.example;

import java.util.Arrays;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/18
 */
public class MergeRank {
    private static final String TAG = "MergeRank";

    public static void main(String[] args) {
        int[] array = Constant.array;
        if (null == array) {
            return;
        }
        int length = array.length;
        int[] mergeArray = mergeSort(array);
        for (int i = 0; i < length; i++) {
            System.out.println(mergeArray[i] + " ");
        }
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
        int length = left.length + right.length;
        int[] result = new int[length];
        for (int i = 0, index_left = 0, index_right = 0; i < length; i++) {
            if (index_right == right.length) {
                result[i] = left[index_left++];
            } else if (index_left == left.length) {
                result[i] = right[index_right++];
            } else if (left[index_left] > right[index_right]) {
                result[i] = right[index_right++];
            } else {
                result[i] = left[index_left++];
            }
        }
        return result;
    }
}
