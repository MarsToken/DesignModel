package com.example.designmodel.leetcode.arrayandstring;

/**
 * 26.删除有序数组中的重复项
 */
public class M3Delete {
    private static final String TAG = "M3Delete";

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
