package com.example.designmodel.leetcode.treesearch;

import com.example.designmodel.leetcode.tree.TreeNode;

/*
 * 特别注意
 */
public class 验证二叉搜索树98 {
    private static final String TAG = "验证二叉搜索树98";
    private Integer pre = null; // 1.不能是Integer.MAX_VALUE
    private boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return isValid;
    }

    private void dfs(TreeNode root) {
        if (root == null || !isValid) { // 2.提前终止无效分支，必须加 !isValid判断。
            return;
        }
        dfs(root.left);
        if (pre != null) {
            if (pre >= root.val) {
                isValid = false;
                return;
            }
        }
        pre = root.val;
        dfs(root.right);
    }

}
