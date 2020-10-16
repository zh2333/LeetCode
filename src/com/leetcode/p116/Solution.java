package com.leetcode.p116;

import com.leetcode.datastructure.TreeNode;
import com.leetcode.utils.MyTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    @Test
    public void test() {
        TreeNode root = MyTree.generatePerfectTree(3);
        MyTree.show(root);
        root = connect(root);
        MyTree.show(root);

    }
    public TreeNode connect(TreeNode root) {
        if (root == null) return root;
        List<List<TreeNode>> levels = levelFind(root);

        for (List<TreeNode> level: levels) {
            int size = level.size();
            for (int i = 0; i < size; i++) {
                if (i != size - 1) {
                    level.get(i).next = level.get(i + 1);
                } else {
                    level.get(i).next = null;
                }
            }
        }
        return root;
    }

    public List<List<TreeNode>>  levelFind(TreeNode root) {
        List<List<TreeNode>> res = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            int size = nodes.size();
            ArrayList<TreeNode> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                level.add(node);
                if (node != null && node.left != null) nodes.add(node.left);
                if (node != null && node.right != null) nodes.add(node.right);
            }
            res.add(level);
        }

        return res;
    }
}
