package com.example.designmodel.rank.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
}
