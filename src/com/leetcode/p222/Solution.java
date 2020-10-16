package com.leetcode.p222;

import com.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
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
                if(root.left != null) levels.add(root.left);
                if(root.right != null) levels.add(root.right);
            }
            count += level.size();
        }
        return count;
    }
}
