package com.offer.offer68;

import com.leetcode.datastructure.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == root || q == root) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            //两个不互为公共祖先
            if (left != null && right != null) {
                return root;
            }
            return left != null ? left : right;
    }
}
