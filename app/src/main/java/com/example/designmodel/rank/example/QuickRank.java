package com.example.designmodel.rank.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/17
 */
public class QuickRank {
    private static final String TAG = "QuickRank";

    public static void main(String[] args) {
        int[] array = Constant.array;
        if (null == array) {
            return;
        }
        int length = array.length;
        quickSort(array, 0, length - 1);
        for (int i = 0; i < length; i++) {
            System.out.println(array[i] + " ");
        }
        String[] str = "a good   example".split(" ");
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("")) {
                continue;
            }
            System.out.println(str[i]);
        }
    }

    /* 快速排序 */
    static void quickSort(int[] nums, int left, int right) {
        // 子数组长度为 1 时终止递归
        if (left >= right)
            return;
        // 哨兵划分
        int pivot = partition(nums, left, right);
        // 递归左子数组、右子数组
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    /* 元素交换 */
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /* 哨兵划分 */
    private static int partition(int[] nums, int left, int right) {
        // 以 nums[left] 为基准数
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left])
                j--;          // 从右向左找首个小于基准数的元素
            while (i < j && nums[i] <= nums[left])
                i++;          // 从左向右找首个大于基准数的元素
            swap(nums, i, j); // 交换这两个元素
        }
        swap(nums, i, left);  // 将基准数交换至两子数组的分界线
        return i;             // 返回基准数的索引
    }

    // 151. 反转字符串中的单词
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals("")) {
                list.add(strings[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            if(i!=0){
                sb.append("");
            }
        }
        return sb.toString();
    }

}
