package com.example.designmodel.leetcode.tree;

/**
 *
 */
public class 对称二叉树101 {
    private static final String TAG = "对称二叉树101";

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
        }
    }
}
