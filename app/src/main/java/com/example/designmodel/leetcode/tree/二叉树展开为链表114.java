package com.example.designmodel.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class 二叉树展开为链表114 {
    private static final String TAG = "二叉树展开为链表114";

    //前序遍历 中左右
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
