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
        countingSorts(array);
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

    /**
     * 支持包含负数的计数排序
     */
    private static void countingSorts(int[] array) {
        if (array.length == 0) return;

        // 1. 同时找出最大值和最小值
        int max = array[0];
        int min = array[0];
        for (int num : array) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // 计算偏移量（将min映射到0）
        int offset = -min;
        int range = max - min + 1;
        int[] buckets = new int[range];

        // 2. 统计元素频率（应用偏移量）
        for (int num : array) {
            buckets[num + offset]++;
        }

        // 3. 回写排序结果（恢复原始值）
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            int originalValue = i - offset; // 恢复原始数值
            for (int j = 0; j < buckets[i]; j++) {
                array[index++] = originalValue;
            }
        }
    }

}
