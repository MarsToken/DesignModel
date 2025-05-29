package com.example.designmodel.leetcode.slidewindow;

/**
 * 长度最小的子数组209
 */
public class 长度最小的子数组209 {
    private static final String TAG = "长度最小的子数组209";

    public int minSubArrayLen2(int target, int[] nums) {
        int length = nums.length;
        int sum = 0;
        int count = Integer.MAX_VALUE;
        for (int left = 0, right = 0; right < length; right++) {
            sum += nums[right];
            while (sum >= target) {
                count = Math.min(count, right - left + 1);
                sum -= nums[left]; // 注意移除的是左边的元素，而不是重复元素！！！
                left++;
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}
