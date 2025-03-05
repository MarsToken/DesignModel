package com.example.designmodel.rank;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯算法
 *
 * @author WangMaoBo
 * @since 2025/2/21
 */

/**
 * 回溯
 * 一种通过穷举来解决问题的方法
 * 回溯算法通常采用“深度优先搜索”来遍历解空间
 * 之所以称之为回溯算法，是因为该算法在搜索解空间时会采用“尝试”与“回退”的策略
 */
public class HuiSu {
    private static final String TAG = "HuiSu";

    /**
     * 1
     * 7   3
     * 4 5  6 7
     *
     * @param args
     */
    @SuppressLint("NewApi")
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        searchTreeNode(root, 7);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("节点7:" + list.get(i));
        }
        list.clear();
        System.out.println("11111111111111111111111111111111111111111111");
        searchAndReturnPath(root, 7);
        lists.forEach(treeNodes -> {
            StringBuffer sb = new StringBuffer();
            sb.append("节点7：");
            for (int i = 0; i < treeNodes.size(); i++) {
                sb.append(treeNodes.get(i).value);
            }
            System.out.println(sb);
        });
        System.out.println("2222222222222222222222222222222222222222222222222");
        list.clear();
        lists.clear();
        searchAndReturnPathWithCut(root, 7, 3);
        lists.forEach(treeNodes -> {
            StringBuffer sb = new StringBuffer();
            sb.append("减枝后的节点7：");
            for (int i = 0; i < treeNodes.size(); i++) {
                sb.append(treeNodes.get(i).value);
            }
            System.out.println(sb);
        });
        System.out.println("333333333333333333333333333333333333333333333333");
        list.clear();
        lists.clear();
        // fillChoice(list, root);
        List<TreeNode> choices = new ArrayList<>();
        choices.add(root);
        searchAndReturnPathWithCut2(root, choices, lists);
        lists.forEach(treeNodes -> {
            StringBuffer sb = new StringBuffer();
            sb.append("减枝后的节点7：");
            for (int i = 0; i < treeNodes.size(); i++) {
                sb.append(treeNodes.get(i).value);
            }
            System.out.println(sb);
        });
        list.clear();
        lists.clear();
        System.out.println("4444444444444444444444444444444444444444444444444");
        // getAllRank(list);
    }

    private static void fillChoice(List<TreeNode> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        fillChoice(list, root.left);
        fillChoice(list, root.right);
    }


    private static void getAllRank(List<Integer> list) {

    }

    // 万能解，伪代码

//    private static void model() {
//        // 检查是否为解
//        if (isSolution(state)) {
//            // 记录解
//            recordSolution(state, res);
//        }
//        // 遍历所有选择
//        for (TreeNode choice : choices) {
//            // 剪枝：检查选择是否合法
//            if (isValid(state, choice)) {
//                // 尝试：做出选择，更新状态
//                makeChoice(state, choice);
//                // 进行下一轮选择
//                backtrack(state, Arrays.asList(choice.left, choice.right), res);
//                // 回退：撤销选择，恢复到之前的状态
//                undoChoice(state, choice);
//            }
//        }
//    }

    /**
     * 在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径，并要求路径中不包含值为3的节点
     * 套用万能公式
     */
    private static void searchAndReturnPathWithCut2(TreeNode state, List<TreeNode> choices,
                                                    List<List<TreeNode>> result) {
        new Model2().backTrack(new ArrayList(), choices, result);
    }

    /**
     * 在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径，并要求路径中不包含值为3的节点
     * 前序遍历
     */
    private static void searchAndReturnPathWithCut(TreeNode root, int targetValue, int excludeValue) {
        if (root == null || root.value == excludeValue) {
            return;
        }
        list.add(root);
        if (root.value == targetValue) {
            lists.add(new ArrayList<>(list));
        }
        searchAndReturnPathWithCut(root.left, targetValue, excludeValue);
        searchAndReturnPathWithCut(root.right, targetValue, excludeValue);
        list.remove(list.size() - 1);
    }

    // ==================================================================================================

    /**
     * 给定一棵二叉树，搜索并记录所有值为7的节点，请返回节点列表。
     */
    private static List<TreeNode> list = new ArrayList<>();

    private static void searchTreeNode(TreeNode root, int value) {
        if (root == null) {
            return;
        }
        if (root.value == value) {
            list.add(root);
        }
        searchTreeNode(root.left, value);
        searchTreeNode(root.right, value);
    }

    private static List<List<TreeNode>> lists = new ArrayList<>();

    /**
     * 在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径。
     */
    private static void searchAndReturnPath(TreeNode root, int value) {
        if (root == null) {
            return;
        }
        // try
        list.add(root);
        if (root.value == value) {
            lists.add(new ArrayList<>(list));
        }
        searchAndReturnPath(root.left, value);
        searchAndReturnPath(root.right, value);
        // back
        list.remove(list.size() - 1);
    }

    /**
     * 在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径，并要求路径中不包含值为3的节点
     * 套用万能公式
     */
    static class Model2 extends Model<TreeNode> {

        @Override
        void undoChoice(List<TreeNode> state, TreeNode choice) {
            state.remove(state.size() - 1);
        }

        @Override
        void attemptChoice(List<TreeNode> state, TreeNode choice) {
            state.add(choice);
        }

        @Override
        boolean isValid(List<TreeNode> state, TreeNode choice) {
            return choice != null && choice.value != 3;
        }

        @Override
        void recordSolution(List<TreeNode> state, List<List<TreeNode>> result) {
            result.add(new ArrayList<>(state));
        }

        @Override
        boolean isSolution(List<TreeNode> state) {
            return !state.isEmpty() && state.get(state.size() - 1).value == 7;
        }

        @Override
        List<TreeNode> getChoices(TreeNode choice) {
            return Arrays.asList(choice.left, choice.right);
        }
    }

    /**
     * 回溯万能模板
     *
     * @param <T>
     */
    static abstract class Model<T> {

        public void backTrack(
            List<T> state,
            List<T> choices,
            List<List<T>> result
        ) {
            if (isSolution(state)) {
                recordSolution(state, result);
                return;
            }
            for (T choice : choices) {
                if (isValid(state, choice)) { // 有效的走，剪枝
                    attemptChoice(state, choice);
                    backTrack(state, getChoices(choice), result); // Arrays.asList(choice.left, choice.right)
                    undoChoice(state, choice);
                }
            }
        }

        abstract void undoChoice(List<T> state, T choice);

        abstract void attemptChoice(List<T> state, T choice);

        abstract boolean isValid(List<T> state, T choice);

        abstract void recordSolution(List<T> state, List<List<T>> result);

        abstract boolean isSolution(List<T> state);

        abstract List<T> getChoices(T t);
    }

}
