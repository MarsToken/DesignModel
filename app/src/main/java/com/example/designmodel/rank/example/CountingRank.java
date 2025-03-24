package com.example.designmodel.rank.example;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/21
 */
public class CountingRank {
    private static final String TAG = "CountingSort";

    public static void main(String[] args) {
        int[] array = Constant.array;
        if (null == array) {
            return;
        }
        int length = array.length;
        if (length < 2) {
            return;
        }
        countingSort(array);
        for (int i = 0; i < length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    /**
     * 适用于非负整数，枚举少的场景
     */
    private static void countingSort(int[] array) {
        // 1.找出最大值并创建最大值+1个桶
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int[] buckets = new int[max + 1];
        // 2.计算并记录桶里每个数字出现的频率
        // 备注：counters天然有序
        for (int element : array) {
            buckets[element]++;
        }
        // 3.将有序集合保存到array里
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                array[index++] = i;
            }
        }

    }
}
