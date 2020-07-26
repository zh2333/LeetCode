package com.leetcode.levelfind;

import java.util.LinkedList;
import java.util.List;

import com.leetcode.datastructure.TreeNode;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       if(root == null) return null;
       LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
       LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
       queue.add(root);
       int size;//记录每层有多少节点数
       
       while(!queue.isEmpty()){//比那里完成退出,返回结果
    	   size = queue.size();
    	   List<Integer> level = new LinkedList<Integer>();
    	   for (int i = 0; i < size; i++) {
			TreeNode currNode = queue.poll();
			level.add(currNode.val);
			if(root.left != null) queue.add(root.left);
			if(root.right != null) queue.add(root.right);
		}
    	   result.addFirst(level);
       }
       return result;
    }
}