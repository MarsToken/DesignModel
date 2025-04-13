package com.example.designmodel.rank.example;

import java.util.Arrays;

/**
 * Created by WangMaoBo.
 * Date: 2025/4/13
 */
public class Dynamic {
    private static final String TAG = "Dynamic";

    public static void main(String[] args) {
        int[] weights = new int[]{1, 2, 3, 4};
        int[] values = new int[]{1, 2, 3, 5};
        int capcity = 7;
        int index = weights.length; // 从0开始，逆序
        int maxValue = pickPackage(weights, values, index, capcity);
        System.out.println("maxValue=" + maxValue);
        maxValue = pickAllPackages(weights, values, 7);
        System.out.println("maxValue2=" + maxValue);

    }

    /**
     * f(n)=f(n-1)+f(n-2)
     * f(1)=1
     * f(2)=2
     * <p>
     * dp[i]=dp[i-1]+dp[i-2]
     */
    public int climClamp(int n) {
        // 边界
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // 转移方程
        return climClamp(n - 1) + climClamp(n - 2);
    }

    /**
     * 记忆化搜索
     */
    public int climClampDFS(int n) {
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return climClamp1(n, mem);
    }

    public int climClamp1(int n, int[] mem) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (mem[n] != -1) {
            return mem[n];
        }
        int count = climClamp1(n - 1, mem) + climClamp1(n - 2, mem);
        mem[n] = count;
        return count;
    }

    /**
     * 动态规划
     * 1.一次走1步或2步，一个n阶阶梯 一共有几种走法
     */
    public int climClamp2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1, b = 2;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    /**
     * dp[i][c]=Math.max(dp[i-1][c],dp[i-1][c-weights[i-1]]+value[i-1])
     * dp[c]=Math(dp[c],dp[i-1][c-weight[i-1]+value[i-1]])
     * <p>
     * i代表当前为第几个物品，从1开始
     * c表示背包的剩余容量
     * <p>
     * 暴力搜索
     */
    public static int pickPackage(int[] weights, int[] values, int i, int c) {
        // 基本情况1：如果没有物品可选(i=0)或背包容量为0(c=0)，价值为0
        // 边界处理
        if (i == 0 || c == 0) {
            System.out.println("基本情况1:" + i + "," + c);
            return 0;
        }
        // 基本情况2：当前物品重量超过剩余容量，只能跳过
        // 特殊情况处理
        if (weights[i - 1] > c) {
            System.out.println("基本情况2:" + c);
            return pickPackage(weights, values, i - 1, c);
        }
        //递归情况：考虑两种情况
        // 1.不选当前物品：直接考虑前i-1个物品
        int notChoiceI = pickPackage(weights, values, i - 1, c);
        // 2.选当前物品：价值增加val[i-1]，容量减少wgt[i-1]
        int choiceI = pickPackage(weights, values, i - 1, c - weights[i - 1]) + values[i - 1];
        System.out.println("notChoiceI:" + notChoiceI + ",choiceI:" + choiceI);
        return Math.max(notChoiceI, choiceI);
    }

    // 记忆化搜索 复杂度：n*cap 看 mem
    public static int pickPackage1(int[] weights, int[] values, int i, int c, int[][] mem) {
        if (i == 0 || c == 0) {
            return 0;
        }
        // 剪枝
        if (mem[i][c] != -1) {
            return mem[i][c];
        }
        if (weights[i - 1] > c) {
            return pickPackage1(weights, values, i - 1, c, mem);
        }
        int notChoiceI = pickPackage1(weights, values, i - 1, c, mem);
        int choiceI = pickPackage1(weights, values, i - 1, c - weights[i - 1], mem) + values[i - 1];
        mem[i][c] = Math.max(notChoiceI, choiceI);
        return mem[i][c];
    }

    /**
     * 动态规划
     * dp[n][cap] n表示当前物品编号,cap表示总背包容量，dp表示总价值
     */
    public static int pickPackage2(int[] weights, int[] values, int cap) {
        int n = weights.length;
        int dp[][] = new int[n + 1][cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = cap; j >= 1; j--) {
                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[n][cap];
    }

    // 一维数组
    public static int pickPackage3(int[] weights, int[] values, int cap) {
        int n = weights.length;
        int dp[] = new int[cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                if (weights[i - 1] > j) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[cap];
    }

    /**
     * 完全背包问题 状态转移中有一处从i-1变为i，其余完全一致
     * dp[i][c]=Math.max(dp[i-1][c],dp[i][c-weights[i-1]]+value[i-1])
     */
    public static int pickAllPackages(int[] weights, int[] values, int cap) {
        int n = weights.length;
        int dp[][] = new int[n + 1][cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else { // dp[i-1][j - weights 改为 dp[i][j - weights
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[n][cap];
    }

    /**
     * 硬币问题
     * <p>
     * dp[i][a]=min(dp[i-1][a],dp[i][amount-coins[i-1]]+1)
     */
    public static int choiceHardCoin(int coins[], int amount) {
        int n = coins.length;
        int MAX = amount + 1;
        int[][] dp = new int[n + 1][amount + 1];
        for (int a = 1; a <= amount; a++) {
            dp[0][a] = MAX;
        }
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= amount; a++) {
                if (coins[i - 1] > a) {
                    dp[i][a] = dp[i - 1][a];
                } else {
                    dp[i][a] = Math.min(dp[i - 1][a], dp[i][a - coins[i - 1]] + 1);
                }
            }
        }
        return dp[n][amount] == MAX ? -1 : dp[n][amount];
    }

}
