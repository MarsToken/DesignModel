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
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    // o(lgn2)
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = calcLevel(root.left);
        int right = calcLevel(root.right);
        if (left == right) {
            return countNodes2(root.right) + (1 << left); // 完满二叉树，表示 2^left次方
        } else {
            return countNodes2(root.left) + (1 << right); // 右边没满
        }

    }

    private int calcLevel(TreeNode node) {
        if(node ==null){
            return 0;
        }
        int count=0;
        while (node!=null){
            count++;
            node=node.left;
        }
        return count;
    }
}
