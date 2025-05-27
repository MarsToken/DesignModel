package com.example.designmodel.leetcode.arrayandstring;

/**
 * 27.移除元素
 */
public class M2Remove {
    private static final String TAG = "M2Remove";

    public int removeElement(int[] nums, int val) {
        // 用于记录index对应的取值不是0的元素！
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
