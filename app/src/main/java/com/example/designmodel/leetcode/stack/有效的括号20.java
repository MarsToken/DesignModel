package com.example.designmodel.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 */
public class 有效的括号20 {
    private static final String TAG = "有效的括号20";

    public static boolean isValid(String s) {
        if (null == s) {
            return false;
        }
        int length = s.length();
        if (length == 0 || length % 2 == 1) {
            return false;
        }
        // 注意key value
        Map<Character, Character> map = new HashMap() {{
            put( ')','(');
            put( ']','[');
            put( '}','{');
        }};
        LinkedList<Character> stack = new LinkedList<>(); // []
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) { // ]
                if (stack.isEmpty() || map.get(ch) != stack.pop()) { // [
                    return false;
                }
            } else {
                stack.push(ch); // [
            }
        }
        return stack.isEmpty();
    }

}
