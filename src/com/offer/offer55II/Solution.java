package com.offer.offer55II;

import com.leetcode.datastructure.TreeNode;

class Solution {
    public boolean isBalanced(TreeNode root) {
    	if(root == null) return true;
    	return Math.abs(getDepth(root.left)-getDepth(root.right)) < 2 && isBalanced(root.left)&&isBalanced(root.right);
    }
    
    public int getDepth(TreeNode root){
    	if(root ==null) return 0;
    	return Math.max(getDepth(root.left), getDepth(root.right))+1;
    }
}