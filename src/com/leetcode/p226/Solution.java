package com.leetcode.p226;

import com.leetcode.datastructure.TreeNode;

/**
 * ��ת������:��������������������
 * @author �ź�
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