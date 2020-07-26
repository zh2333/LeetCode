package com.leetcode.p105;

import java.util.Arrays;

import com.leetcode.datastructure.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
	注意:
	你可以假设树中没有重复的元素。
	例如，给出
	前序遍历 preorder = [3,9,20,15,7]
	中序遍历 inorder = [9,3,15,20,7]
	返回如下的二叉树：
	    3
	   / \
	  9  20
	    /  \
	   15   7
 * @author 张恒
 *
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder.length == 0 || inorder.length == 0) return null;
    	TreeNode root = new TreeNode(preorder[0]);
    	int len = preorder.length;
    	for (int i = 0; i < len; i++) {
    		//找到了子树的根节点
			if(preorder[0] == inorder[i]){
				//将前序数组和中序数组分别分成两个部分,递归求得
				int[] pre_left = Arrays.copyOfRange(preorder, 1, i+1 );
				int[] pre_right = Arrays.copyOfRange(preorder, i+1, len);
				int[] in_left = Arrays.copyOfRange(inorder, 0, i);
				int[] in_right = Arrays.copyOfRange(inorder, i+1,len);
				
				root.left = buildTree(pre_left, in_left);
				root.right = buildTree(pre_right, in_right);
				break;
			}
		}
		return root;
    }
}
