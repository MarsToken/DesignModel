package com.example.designmodel.leetcode.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和
 */
public class 三数之和 {
    private static final String TAG = "M5ThreeSum";

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 先排序
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 双指针，目标是找到 nums[l] + nums[r] = -nums[i]
            int l = i + 1, r = nums.length - 1;
            int target = -nums[i];

            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    // 跳过重复元素
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int third = nums[i];
            while (left < right) {
                int result = nums[left] + nums[right] + third;
                if (result == 0) {
                    res.add(Arrays.asList(third, nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (result > 0) {
                    right--;
                } else {
                    left++;
                }
            }

        }
        return res;
    }
}
