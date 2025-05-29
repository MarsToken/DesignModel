package com.example.designmodel.leetcode.doublepointer;

/**
 * 125.验证回文串
 */
public class 验证回文串125 {
    private static final String TAG = "M1CheckCycleString";

    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase((s.charAt(i))));
            }
        }
        // 双指针。头尾法
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
