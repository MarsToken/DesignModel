package com.example.designmodel.leetcode.treetravel;

import com.example.designmodel.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by WangMaoBo.
 * Date: 2025/6/6
 */
public class 二叉树的锯齿形层序遍历103 {
    private static final String TAG = "二叉树的锯齿形层序遍历103";

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean startFromLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode top;
                if (startFromLeft) {
                    top = queue.pollFirst();
                    if (top.left != null) queue.offer(top.left);
                    if (top.right != null) queue.offer(top.right);
                } else {
                    top = queue.pollLast();
                    if (top.right != null) queue.offerFirst(top.right);
                    if (top.left != null) queue.offerFirst(top.left);
                }
                list.add(top.val);
            }
            lists.add(list);
            startFromLeft = !startFromLeft;
        }
        return lists;
    }
}
