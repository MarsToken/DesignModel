package com.example.designmodel.leetcode.treetravel;

import com.example.designmodel.leetcode.tree.TreeNode;
import com.example.designmodel.rank.datastructure.queue.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 3
 * 9   20
 * 15  7
 * Created by WangMaoBo.
 * Date: 2025/6/6
 */
public class 二叉树的锯齿形层序遍历103 {
    private static final String TAG = "二叉树的锯齿形层序遍历103";

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> results = zigzagLevelOrder(root);
        for (List<Integer> result : results) {
            for (int element : result) {
                System.out.print(element);
                System.out.print(",");
            }
            System.out.println("");
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Deque<TreeNode> queue = new LinkedList<>(); // 双端队列

        queue.offer(root);
        boolean startFromLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                /*
                 *      3
                 *  9     20
                 *      15  7
                 *
                 */
                TreeNode top;
                if (startFromLeft) { // 9 20
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
