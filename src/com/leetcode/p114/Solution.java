package com.leetcode.p114;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.datastructure.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为链表。
	例如，给定二叉树
	
	    1
	   / \
	  2   5
	 / \   \
	3   4   6
	将其展开为：
	
	1
	 \
	  2
	   \
	    3
	     \
	      4
	       \
	        5
	         \
	          6
 * @author 张恒
 *
 */
class Solution {
    public void flatten(TreeNode root) {
    	LinkedList<TreeNode> res = new LinkedList<TreeNode>();
    	if(root == null) return;
    	preOrder(root,res);
    	
    	TreeNode head = res.removeFirst();
    	head.left = null;
    	while(res.size()>0){
    		//先将左子树根节点暂存
    		TreeNode temp = res.removeFirst();
    		temp.left = null;
    		head.right = temp;
    		head = head.right;
    	}
    	
    	
    }
    
    
    //将树中的节点按照前序遍历的顺序放到list中
    public void preOrder(TreeNode root,LinkedList<TreeNode> res){
    	if(root == null) return;
    	
    	res.add(root);
    	preOrder(root.left, res);
    	preOrder(root.right, res);
    }
}
