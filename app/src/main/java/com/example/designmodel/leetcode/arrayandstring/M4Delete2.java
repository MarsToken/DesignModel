package com.example.designmodel.leetcode.arrayandstring;

/**
 * 80.删除有序数组中的重复项②
 */
public class M4Delete2 {
    private static final String TAG = "M4Delete2";
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n<=2) {
            return n;
        }
        int fast = 2, slow = 2;
        while (fast < n) {
            // 注意此判断
            if (nums[fast] != nums[slow-2]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
