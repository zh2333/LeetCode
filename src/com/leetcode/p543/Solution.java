package com.leetcode.p543;

import com.leetcode.datastructure.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
	示例 :
	给定二叉树
	
	          1
	         / \
	        2   3
	       / \     
	      4   5    
	返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
	注意：两结点之间的路径长度是以它们之间边的数目表示。

 * @author 张恒
 *
 */
class Solution {
	static int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
    	dfs(root);
    	return res;
    }
    
    public static int dfs(TreeNode node){
    	if(node == null) return 0;
    	
    	int leftDepth = dfs(node.left);
    	int rightDepth = dfs(node.right);
    	
    	//更新当前节点的最大直径
    	res = Math.max(res, leftDepth+rightDepth);
    	//将当前节点的深度返回给上一层父节点
    	return Math.max(leftDepth, rightDepth)+1;
    	
    }
}