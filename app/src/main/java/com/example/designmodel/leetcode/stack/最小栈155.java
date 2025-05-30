package com.example.designmodel.leetcode.stack;

import java.util.LinkedList;

/**
 *
 */
public class 最小栈155 {
    private static final String TAG = "最小栈151";

    class MinStack {
        private LinkedList<Integer> stack;
        private LinkedList<Integer> minStack;

        public MinStack() {
            stack = new LinkedList();
            minStack = new LinkedList();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}