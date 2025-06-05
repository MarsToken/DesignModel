package com.example.designmodel.leetcode.tree;

/**
 *
 */
public class 路径总和112 {
    private static final String TAG = "路径总和112";

    // 思路 考虑所有条件的全集！
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return root.val == targetSum;
        } else {
            // 注意是targetSum - root.val 而不是 targetSum
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }
}
