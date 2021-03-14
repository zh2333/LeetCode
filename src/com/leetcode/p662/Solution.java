package com.leetcode.p662;

import com.leetcode.datastructure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        int currLevel = 1;
        int currLevelNodes = 0;
        int max = Integer.MIN_VALUE;
        queue.add(root);
        levelMap.put(root, 1);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int currNodeLevel = levelMap.get(curr);
            if (currLevel == currNodeLevel) {
                currLevelNodes++;
            } else {
                max = Math.max(max, currLevelNodes);
                currLevel++;
                currLevelNodes = 1;
            }
            if (curr.left !=null) {
                levelMap.put(curr.left, currNodeLevel+1);
                queue.add(curr.left);
            }
            if (curr.right != null) {
                levelMap.put(curr.right, currNodeLevel+1);
                queue.add(curr.right);
            }
        }
        return max;
    }
}
