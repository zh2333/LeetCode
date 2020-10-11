package com.leetcode.datastructure;

public class TreeNode {
	 public int val;
	 public TreeNode left;
	 public TreeNode right;
	 public TreeNode(int x) {
	 	this.val = x;
		 this.left = null;
		 this.right = null;
	 }
	 TreeNode(int val, TreeNode left , TreeNode right ) {
		this.val = val;
		this.left = left;
		this.right = right;
     }


	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
}