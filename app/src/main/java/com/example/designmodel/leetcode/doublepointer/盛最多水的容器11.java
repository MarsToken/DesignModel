package com.example.designmodel.leetcode.doublepointer;

/**
 *
 */
public class 盛最多水的容器11 {
    private static final String TAG = "盛最多水的容器11";

    // 贪心实战，为什么要用头尾法而不是滑动窗体？因为求最大值，所以长宽越大越好！
    public int maxArea(int[] height) {
        int sub = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int tempSub = (right - left) * Math.min(height[left], height[right]);
            sub = Math.max(sub, tempSub);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return sub;
    }
}
