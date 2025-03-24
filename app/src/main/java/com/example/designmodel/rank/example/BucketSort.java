package com.example.designmodel.rank.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/20
 */
public class BucketSort {
    private static final String TAG = "BucketSort";

    public static void main(String[] args) {
//        float[] array = new float[]{
//                0.1f, 0.9f, 0.8f, 0.5f, 0.7f
//        };
//        buketSort(array);
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }

        int[] array = Constant.array;
        if (null == array) {
            return;
        }
        int length = array.length;
        buketSort(array);
        for (int i = 0; i < length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    private static void buketSort(float[] array) {
        // 1.初始化桶
        int element_count = 2;
        int k = array.length / element_count;
        List<List<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new ArrayList<>());
        }
        // 2.给k个桶赋初始值
        for (float num : array) {
            int index = (int) (num * k);
            buckets.get(index).add(num);
        }
        // 3.为各个桶执行排序
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }
        // 4.遍历桶合并结果
        int i = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) {
                array[i++] = num;
            }
        }
    }

    private static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static void buketSort(int[] array) {
        int max = findMax(array);
        int deep = 2;
        int size = array.length / deep;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            buckets.add(new ArrayList<>());
        }
        for (Integer element : array) {
            int index = (element) / (max) * (size - 1);
            buckets.get(index).add(element);
        }
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int i = 0;
        for (List<Integer> bucket : buckets) {
            for (Integer element : bucket) {
                array[i++] = element;
            }
        }
    }

}
