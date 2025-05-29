package com.example.designmodel.leetcode.doublepointer;

/**
 * 392.判断子序列
 */
public class 判断子序列392 {
    private static final String TAG = "M2CheckChildQueue";

    // 判断 s 是否为 t 的子序列
    public boolean isSubsequence(String s, String t) {
        int s_length = s.length();
        int t_length = t.length();
        int s_index = 0, t_index = 0;
        while (s_index < s_length && t_index < t_length) {
            if (s.charAt(s_index) == t.charAt(t_index)) {
                s_index++;
            }
            t_index++;
        }
        return s_index == s_length;
    }
}
