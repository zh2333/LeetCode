package com.leetcode.p538;

import com.leetcode.datastructure.TreeNode;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
	例如：
	输入: 原始二叉搜索树:
	              5
	            /   \
	           2     13
	
	输出: 转换为累加树:
	             18
	            /   \
	          20     13
	
	 * @author 张恒
	 *
	 */
class Solution {
    public TreeNode convertBST(TreeNode root) {
    	if(root != null){
    		dfs(root,0);
    	}
    	return root;
    }
    
    public static int dfs(TreeNode node,int sum){
    	if(node == null) return sum;
    	
    	sum = dfs(node.right,sum);
    	node.val += sum;
    	sum  = dfs(node.left,node.val);
		return sum;
    	
    }
}
