package com.example.designmodel.pattern.structure.combinePattern;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by hp on 2020/3/13.
 */
public class TreeNode {
    private String name;
    private TreeNode parent;
    //List 可以通过索引get遍历，也可以通过elements遍历，类似Iterator
    private Vector<TreeNode> children = new Vector<>();

    public TreeNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void add(TreeNode node) {
        children.add(node);
    }

    public void remove(TreeNode node) {
        children.remove(node);
    }

    public Enumeration<TreeNode> getChildren() {
        return children.elements();
    }

    public void travel() {
        Enumeration<TreeNode> enumerations = children.elements();
        while (enumerations.hasMoreElements()) {
            System.out.println("next element=" + enumerations.nextElement().name);
        }
    }
}
