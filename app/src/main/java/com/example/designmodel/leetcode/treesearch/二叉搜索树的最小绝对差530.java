package com.example.designmodel.leetcode.treesearch;

import com.example.designmodel.leetcode.tree.TreeNode;

/**
 *
 */
public class 二叉搜索树的最小绝对差530 {
    private static final String TAG = "二叉搜索树的最小绝对差530";
    int pre;
    int min;

    // 二叉搜索树中序遍历天然有序 左中右
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = -1;
        calcMin(root.left);
        return min;
    }

    private void calcMin(TreeNode root) {
        if (root == null) {
            return;
        }
        calcMin(root.left);
        if (pre != -1) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        calcMin(root.right);
    }

}
