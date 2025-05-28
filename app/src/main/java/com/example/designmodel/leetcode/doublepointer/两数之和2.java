package com.example.designmodel.leetcode.doublepointer;

/**
 * 167.两数之和2-输入有序数组
 */
public class 两数之和2 {
    private static final String TAG = "M3TowSum";

    // 1.二分查找 nlg(n)

    // 2.双指针 头尾法，有序很关键/非递减
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int left = 0, right = length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }

        }
        return new int[]{-1, -1};
    }
}
