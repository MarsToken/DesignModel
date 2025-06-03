package com.example.designmodel.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class 二叉树的最大宽度 {
    private static final String TAG = "二叉树的最大宽度";

    public int getMaxWidthByBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int maxSize = 0;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            maxSize = Math.max(maxSize, currentSize);
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return maxSize;
    }

}
