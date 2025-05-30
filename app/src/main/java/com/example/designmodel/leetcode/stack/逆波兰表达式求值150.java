package com.example.designmodel.leetcode.stack;

import java.util.LinkedList;

/**
 * des
 *
 * @author WangMaoBo
 * @constructor 创建此类对象的主构造函数
 * @since 2025/5/30
 */
public class 逆波兰表达式求值150 {
    private static final String TAG = "逆波兰表达式求值150";

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String element : tokens) {
            if (isNumber(element)) {
                stack.push(Integer.parseInt(element));
            } else {
                // 注意 first,second顺序
                int second = stack.pop();
                int first = stack.pop();
                switch (element) {
                    case "+":
                        stack.push(first + second);
                        break;
                    case "-":
                        stack.push(first - second);
                        break;
                    case "*":
                        stack.push(first * second);
                        break;
                    case "/":
                        stack.push(first / second);
                        break;
                }
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
