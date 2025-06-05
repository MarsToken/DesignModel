package com.example.designmodel.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 *   3
 * 9  20
 *   15 7
 *
 *
 * 解题思路：（分治）
 * 前序遍历性质： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序。
 * 中序遍历性质： 节点按照 [ 左子树 | 根节点 | 右子树 ] 排序。
 *
 * 以题目示例为例：
 *
 * 前序遍历划分 [ 3 | 9 | 20 15 7 ]
 * 中序遍历划分 [ 9 | 3 | 15 20 7 ]
 * 根据以上性质，可得出以下推论：
 *
 * 前序遍历的首元素 为 树的根节点 node 的值。
 * 在中序遍历中搜索根节点 node 的索引 ，可将 中序遍历 划分为 [ 左子树 | 根节点 | 右子树 ] 。[0:i-1,i,i+1:n] i表示根节点在中序遍历中的位置
 * 根据中序遍历中的左（右）子树的节点数量，可将 前序遍历 划分为 [ 根节点 | 左子树 | 右子树 ] 。
 *
 * 通过以上三步，可确定 三个节点 ：1.树的根节点、2.左子树根节点、3.右子树根节点。
 * 根据分治思想，对于树的左、右子树，仍可复用以上方法划分子树的左右子树。
 *
 */
public class 从前序与中序遍历序列构造二叉树105 {
    private static final String TAG = "从前序与中序遍历序列构造二叉树105";

    // 前序：中左右
    // 中序：左中右
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    // 根节点在前序遍历的索引 root 、子树在中序遍历的左边界 left 、子树在中序遍历的右边界 right 。
    TreeNode recur(int root, int left, int right) {
        if (left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        /**
         * i - left + root + 1比较难理解，我试着简单解读一下
         * 首先对于左子树的变量的左右边界很好理解，中序遍历左边界为left,另一边是i-1
         * 所以我们可以计算得到左子树的长度为（i-1）-left+1=i-left
         * 回到前序遍历给出的数组中，从根节点跳过左子树的长度，就可以找到右子树的根节点：即为root+(i-left)+1=i - left + root + 1
         */
        return node;                                           // 回溯返回根节点
    }
}
