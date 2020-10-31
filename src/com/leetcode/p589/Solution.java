package com.leetcode.p589;

import com.leetcode.datastructure.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 * 返回其前序遍历: [1,3,5,6,2,4]。
 */
public class Solution {
    public List<Integer> preorder(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        dg(root, res);
        return res;
    }

    public void dg(Node root, List<Integer> res) {
        if(root != null) {
            res.add(root.val);
        }
        for (Node childern : root.children) {
            dg(childern, res);
        }
    }
}
