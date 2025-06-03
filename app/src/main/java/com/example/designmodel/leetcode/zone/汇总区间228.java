package com.example.designmodel.leetcode.zone;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 List<String> list = new ArrayList<>();
 if (nums.length == 1) {
 list.add("1");
 return list;
 }
 // [0,1,2,4,5,7]
 int i = 0;
 int n = nums.length;
 while (i < n) {
 int low = i;
 i++;
 while (i < n && nums[i] == nums[i - 1] + 1) {
 i++;
 }
 int high = i - 1;
 StringBuffer sb = new StringBuffer();
 sb.append(nums[low]);
 if (low < high) {
 sb.append("->");
 sb.append(nums[high]);
 }
 list.add(sb.toString());
 }
 return list;
 */
public class 汇总区间228 {
    private static final String TAG = "汇总区间228";

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 1) {
            list.add("1");
            return list;
        }
        int index = 0; // index 表示游标 low代表左区间，high代表右区间
        int n = nums.length;
        while (index < n) {
            int low = index;
            index++;
            while (index < n && nums[index] == nums[index - 1] + 1) {
                index++;
            }
            int high = index - 1;
            StringBuffer sb = new StringBuffer();
            sb.append(nums[low]);
            if (low < high) {
                sb.append("->");
                sb.append(nums[high]);
            }
            list.add(sb.toString());
        }
        return list;
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> list = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                stack.push(nums[i]);
            } else {
                int pre = stack.peek();
                if (nums[i] - pre == 1) {
                    stack.push(nums[i]);
                } else {
                    if (stack.size() == 1) {
                        list.add("" + stack.peek());
                    } else {
                        int start = stack.peekLast();
                        int end = stack.peekFirst();
                        list.add(start + "->" + end);
                    }
                    stack.clear();
                    stack.push(nums[i]);
                }
            }
        }
        if (!stack.isEmpty()) {
            if (stack.size() == 1) {
                list.add("" + stack.peek());
            } else {
                int start = stack.peekLast();
                int end = stack.peekFirst();
                list.add(start + "->" + end);
            }
        }
        return list;
    }
}
