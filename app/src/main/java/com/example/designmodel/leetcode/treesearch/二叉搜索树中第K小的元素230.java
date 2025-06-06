package com.example.designmodel.leetcode.treesearch;

import com.example.designmodel.leetcode.tree.TreeNode;

/**
 * 中序遍历
 */
public class 二叉搜索树中第K小的元素230 {
    private static final String TAG = "二叉搜索树中第K小的元素230";

    int minByK = Integer.MAX_VALUE;
    int mIndex = 0;
    int mK;
    public int kthSmallest(TreeNode root, int k) {
        mK=k;
        dfs(root);
        return minByK;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        mIndex++;
        if (mIndex == mK) {
            minByK = root.val;
            return;
        }
        dfs(root.right);
    }
}
