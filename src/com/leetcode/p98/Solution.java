package com.leetcode.p98;

import com.leetcode.datastructure.TreeNode;

public class Solution {
    public static int preValue = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return inOrder(root);
    }
    public boolean inOrder(TreeNode root) {
        boolean isLeftBST = isValidBST(root.left);
        if (!isLeftBST) {
            return false;
        }
        if (root.val <= preValue) {
            return false;
        } else {
            preValue = root.val;
        }
        return isValidBST(root.right);
    }
}
