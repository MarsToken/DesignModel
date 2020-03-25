package com.example.designmodel.pattern.structure.combinePattern;

/**
 * 组合模式有时又叫部分-整体模式在处理类似树形结构的问题时比较方便
 * Created by hp on 2020/3/13.
 */
public class TestMain {
    public static void main(String[] args) {
        Tree tree = new Tree("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        nodeB.add(nodeC);
        tree.root.add(nodeB);
        System.out.println("build the tree finished!");
        tree.root.travel();
    }
}
