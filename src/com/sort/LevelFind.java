package com.sort;

import com.sort.test.TreeNode;


import java.util.LinkedList;
import java.util.List;

class LevelFind {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return null;
       LinkedList<List<Integer>> result = new LinkedList<>();
       LinkedList<TreeNode> levels = new LinkedList<>();
       int size;
       levels.add(root);
       while(!levels.isEmpty()){
           size  = levels.size();
           LinkedList<Integer> level = new LinkedList<>();
           for (int i = 0; i < size; i++) {
               TreeNode currNode = levels.poll();
               level.add(currNode.val);
               if(currNode!=null && currNode.left != null) levels.add(currNode.left);
               if(currNode!=null && currNode.right != null) levels.add(currNode.right);
           }
           result.addLast(level);
       }

        return result;
    }
}