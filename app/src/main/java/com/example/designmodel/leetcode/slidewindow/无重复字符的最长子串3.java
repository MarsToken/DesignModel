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
        int ans = 0;
        int first = 0;
        int second = 0;
        Set<Character> set = new HashSet<>();
        while (second < s.length()) {
            while (set.contains(s.charAt(second))) {
                ans = Math.max(ans, second - first + 1);
                set.remove(s.charAt(first));
                first++;
            }
            set.add(s.charAt(second));
            second++;
        }
        return ans;
    }
}
