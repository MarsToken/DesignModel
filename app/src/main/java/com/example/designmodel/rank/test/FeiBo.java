package com.example.designmodel.rank.test;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/24
 */
public class FeiBo {
    private static final String TAG = "Test";

    public static void main(String[] args) {
        int result = feiBo2(5);
        System.out.println("result=" + result);
    }

    private static int feiBo2(int n) {
        if (n <= 1) return n;
        return feiBo2(n - 1) + feiBo2(n - 2);
    }

    /**
     * 哨兵模式优化斐波那契数列
     */
    private static int feiBo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
