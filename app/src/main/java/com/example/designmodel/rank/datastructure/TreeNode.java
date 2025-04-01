package com.example.designmodel.rank.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/25
 */
public class TreeNode {
    private static final String TAG = "TreeNode";
    public int value;
    public TreeNode left;
    public TreeNode right;

    /**
     * 1
     * 7   3
     * 4 5  6 7
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

    }

    public TreeNode(int value) {
        this.value = value;
    }

    public List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.value);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return list;
    }

    public int getMaxWidth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSize = 0;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            maxSize = Math.max(maxSize, currentSize);
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return maxSize;
    }

    /**
     * 前序遍历：中，左，右
     * 中序遍历：左,中,右
     * 后序遍历：左，右，中
     */
    public void preOrder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.value);
        preOrder(list, root.left);
        preOrder(list, root.right);
    }

    public void midOrder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(list, root.left);
        list.add(root.value);
        midOrder(list, root.right);
    }

    public static void afterOrder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        afterOrder(list, root.left);
        afterOrder(list, root.right);
        list.add(root.value);
    }
}
