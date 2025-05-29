package com.example.designmodel.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 算法分为两部分，我们需要设计和编写代码。
 * <p>
 * 给一个数字 n，它的下一个数字是什么？
 * 按照一系列的数字来判断我们是否进入了一个循环。
 * 第 1 部分我们按照题目的要求做数位分离，求平方和。
 * <p>
 * 第 2 部分可以使用哈希集合完成。每次生成链中的下一个数字时，我们都会检查它是否已经在哈希集合中。
 * <p>
 * 如果它不在哈希集合中，我们应该添加它。
 * 如果它在哈希集合中，这意味着我们处于一个循环中，因此应该返回 false。
 */
public class 快乐数 {
    private static final String TAG = "快乐数";

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        // set目的是判断是否有死循环！
        while (!set.contains(n) && n != 1) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        if (n <= 0) {
            return 0;
        }
        int sum = 0;
        while (n > 0) {
            int cur = n % 10;
            n = n / 10;
            sum += cur * cur;
        }
        return sum;
    }
}
