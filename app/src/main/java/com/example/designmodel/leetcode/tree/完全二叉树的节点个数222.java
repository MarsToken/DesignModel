package com.example.designmodel.leetcode.tree;

/**
 *
 */
public class 完全二叉树的节点个数222 {
    private static final String TAG = "完全二叉树的节点个数222";

    // o(n)
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    // o(n2)

}
