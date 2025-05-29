package com.example.designmodel.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 注意数组是无序的
 */
public class 两数之和1 {
    private static final String TAG = "两数之和1";

    public int[] twoSum(int[] numbers, int target) {
        // key numbers[i] value i
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[0];
    }
}
