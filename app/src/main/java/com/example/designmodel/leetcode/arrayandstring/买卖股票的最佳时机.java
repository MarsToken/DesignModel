package com.example.designmodel.leetcode.arrayandstring;

/**
 * 121.买卖股票的最佳时机
 * 122.买卖股票的最佳时机2
 */
public class 买卖股票的最佳时机 {
    private static final String TAG = "买卖股票的最佳时机";

    // 121.买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxValue = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) { // 买入
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxValue) { // 卖出
                maxValue = prices[i] - minPrice;
            }
        }
        return maxValue;
    }

    // 122.买卖股票的最佳时机2 贪心算法！
    public int maxProfit2(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int tempSum = prices[i] - prices[i - 1];
            if (tempSum >= 0) {
                sum += tempSum;
            }
        }
        return sum;
    }
}
