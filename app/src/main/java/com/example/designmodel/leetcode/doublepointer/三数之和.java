package com.example.designmodel.leetcode.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 15.三数之和
 */
public class 三数之和 {
    private static final String TAG = "M5ThreeSum";


    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
            if (set.contains(nums[i])) {
                continue;
            } else {
                set.add(nums[i]);
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    //if (nums[left] != nums[right] && nums[left] != nums[i] && nums[right] != nums[i]) {
                    res.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    //}
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
