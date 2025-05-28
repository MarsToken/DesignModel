package com.example.designmodel.leetcode.slidewindow;

/**
 * 长度最小的子数组209
 */
public class 长度最小的子数组209 {
    private static final String TAG = "长度最小的子数组209";

    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        // 同方向：头头发
        int ans = Integer.MAX_VALUE;
        int first = 0, second = 0;
        int sum = 0;
        while (second < length) {
            sum += nums[second];
            while (sum >= target) {
                ans = Math.min(ans, second - first + 1);
                sum -= nums[first];
                first++;
            }
            second++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
