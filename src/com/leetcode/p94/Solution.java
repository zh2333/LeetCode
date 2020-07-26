package com.leetcode.p94;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.datastructure.TreeNode;

/**
 * 给定一个二叉树，返回它的中序 遍历。
	示例:
	输入: [1,null,2,3]
	   1
	    \
	     2
	    /
	   3
	   
	输出: [1,3,2]
 * @author 张恒
 *
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
    	if(root == null) return new ArrayList<Integer>();
    	List<Integer> res = new ArrayList<Integer>();
    	LDR(root,res);
		return res;
    }
    
    public void LDR(TreeNode root,List<Integer> res){
    	if(root != null){
    		if(root.left != null){
    			LDR(root.left,res);
    		}
    		res.add(root.val);
    		if(root.right != null){
    			LDR(root.right,res);
    		}
    	}
    }
}
