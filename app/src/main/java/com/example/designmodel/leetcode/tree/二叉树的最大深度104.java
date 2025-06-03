package com.example.designmodel.leetcode.tree;

import java.util.LinkedList;

/**
 * 深度优先遍历
 */
public class 二叉树的最大深度104 {
    private static final String TAG = "二叉树的最大深度104";

    public int maxDepth(TreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * 广度优先遍历
     */
    public int maxDepth2(TreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.push(root);
        while (!list.isEmpty()) {
            int size = list.size();
            count++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = list.poll();
                if (cur.left != null) {
                    list.push(cur.left);
                }
                if (cur.right != null) {
                    list.push(cur.right);
                }
            }
        }
        return count;
    }
}
