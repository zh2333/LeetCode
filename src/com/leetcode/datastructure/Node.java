package com.leetcode.datastructure;

import java.util.List;

<<<<<<< HEAD
public class Node {
    public int val;
    public List<Node> children;
    public Node() {}
=======
/**
 * 多叉树的数据结构
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

>>>>>>> master
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
<<<<<<< HEAD
};
=======

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
};
>>>>>>> master
