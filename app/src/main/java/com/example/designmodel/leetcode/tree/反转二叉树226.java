package com.example.designmodel.leetcode.tree;

/**
 *
 */
public class 反转二叉树226 {
    private static final String TAG = "反转二叉树226";

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
