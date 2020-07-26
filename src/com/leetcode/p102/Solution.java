package com.leetcode.p102;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.datastructure.TreeNode;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
	例如:
	给定二叉树: [3,9,20,null,null,15,7],
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	返回其层次遍历结果：
	
	[
	  [3],
	  [9,20],
	  [15,7]
	]
 * @author 张恒
 *
 */
class Solution {
	List<List<Integer>> levels = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
    	if (root == null) return levels;
    	helper(root,0);
    	return levels;
    }
    
    public void helper(TreeNode root, int level){
    	//到达新的一层,创建一个新的list存放这些元素
    	if(levels.size() == level){
    		levels.add(new ArrayList<Integer>());
    	}
    	
    	levels.get(level).add(root.val);
    	
    	if(root.left != null) helper(root.left,level+1);
    	if(root.right != null) helper(root.right,level+1);
    	
    }
}
