package com.example.designmodel.leetcode.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 */
public class 简化路径71 {
    private static final String TAG = "简化路径71";

    public String simplifyPath(String path) {
        if (path == null || path.equals("")) {
            return "/";
        }
        String[] splitPaths = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < splitPaths.length; i++) {
            String element = splitPaths[i];
            if (element.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (element.equals(".") || element.equals("")) {

            } else {
                stack.push(element);
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append("/");
        while (stack.size() != 0) {
            // 注意 pollLast，因为栈是先进后出
            sb.append(stack.pollLast());
            if (stack.size() != 0) {
                sb.append("/");
            }
        }
        return sb.toString();

    }
}
