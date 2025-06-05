package com.example.designmodel.leetcode.tree;

/**
 *
 */
public class 求根节点到叶节点数字之和129 {
    private static final String TAG = "求根节点到叶节点数字之和129";

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
