package com.example.designmodel.pattern.structure.combinePattern;

/**
 * 使用场景：将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，数等。
 * Created by hp on 2020/3/13.
 */
public class Tree {
    TreeNode root = null;

    public Tree(String name) {
        root = new TreeNode(name);
    }
}
