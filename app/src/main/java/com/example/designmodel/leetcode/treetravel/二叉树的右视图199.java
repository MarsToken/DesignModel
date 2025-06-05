package com.example.designmodel.leetcode.treetravel;

import com.example.designmodel.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by WangMaoBo.
 * Date: 2025/6/5
 */
public class 二叉树的右视图199 {
    private static final String TAG = "二叉树的右视图199";

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
                if(i==size-1){
                    list.add(top.val);
                }
            }
        }
        return list;
    }
}
