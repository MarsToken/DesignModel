package com.example.designmodel.leetcode.slidewindow;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 无重复字符的最长子串3
 */
public class 无重复字符的最长子串3 {
    private static final String TAG = "无重复字符的最长子串3";

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int left = 0, right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                // set中有ch，则缩短左边界，同时从set集合移出left元素
                set.remove(s.charAt(left)); // 注意移除的是左边的元素，而不是重复元素！！！
                left++;
            }
            set.add(s.charAt(right));
            count = Math.max(count, right - left + 1);
        }
        return count;
    }

}
