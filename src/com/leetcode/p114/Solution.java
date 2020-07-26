package com.leetcode.p114;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.datastructure.TreeNode;

/**
 * ����һ����������ԭ�ؽ���չ��Ϊ����
	���磬����������
	
	    1
	   / \
	  2   5
	 / \   \
	3   4   6
	����չ��Ϊ��
	
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
 * @author �ź�
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
    		//�Ƚ����������ڵ��ݴ�
    		TreeNode temp = res.removeFirst();
    		temp.left = null;
    		head.right = temp;
    		head = head.right;
    	}
    	
    	
    }
    
    
    //�����еĽڵ㰴��ǰ�������˳��ŵ�list��
    public void preOrder(TreeNode root,LinkedList<TreeNode> res){
    	if(root == null) return;
    	
    	res.add(root);
    	preOrder(root.left, res);
    	preOrder(root.right, res);
    }
}
