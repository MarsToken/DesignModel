package com.example.designmodel.leetcode.arrayandstring;

import java.util.Arrays;
import java.util.Collections;

/**
 * 88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
 * 分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，
 * 后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class M1Merge {
    private static final String TAG = "M1Merge";

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // for循环是循环的nums2的，将其插入Arrays1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        // Arrays.sort(nums1);
        countingSort(nums1);
    }

    // 计数排序
    private void countingSort(int[] array) {
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }
        int offset = -min;
        int range = max + 1 + offset;
        int[] buckets = new int[range];
        for (int element : array) {
            buckets[element + offset]++;
        }
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                array[index++] = i - offset;
            }
        }
    }

    // 双指针
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int count = 0;
        if (m == 0) {
            count = 0;
        } else {
            for (int i = nums1.length - 1; i >= 0; i--) {
                if (nums1[i] != 0) {
                    break;
                }
                count++;
            }
        }
        int nums3[] = Arrays.copyOfRange(nums1, 0, m - count);
        int length = m;
        int[] result = new int[length];
        for (int i = 0, index_nums3 = 0, index_nums2 = 0; i < length; i++) {
            if (index_nums2 == nums2.length) {
                result[i] = nums3[index_nums3++];
            } else if (index_nums3 == nums3.length) {
                result[i] = nums2[index_nums2++];
            } else if (nums3[index_nums3] > nums2[index_nums2]) {
                result[i] = nums2[index_nums2++];
            } else {
                result[i] = nums3[index_nums3++];
            }
        }
        int index = 0;
        for (int element : result) {
            nums1[index++] = element;
        }
    }
}
