package com.leetcode.p226;

import com.leetcode.datastructure.TreeNode;

/**
 * 翻转二叉树:交换二叉树的左右子树
 * @author 张恒
 *
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
    	if(root == null) return  null;
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	invertTree(root.left);
    	invertTree(root.right);
		
    	return root;
    }
}