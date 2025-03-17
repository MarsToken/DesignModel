package com.example.designmodel.rank.example;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/6
 */
public class ShellRank {
    private static final String TAG = "ShellRank";

    public static void main(String[] args) {
        int[] array = Constant.array;
        if (null == array) {
            return;
        }
        int length = array.length;
        int mid = length;
        do {
            mid /= 2;
            for (int i = mid; i < length - 1; i++) {
                int j = i;
                int current = array[j + 1];
                while (j >= 0 && current < array[j]) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = current;
            }
        } while (mid > 0);

        for (int i = 0; i < length; i++) {
            System.out.println(array[i] + " ");
        }
    }
}
