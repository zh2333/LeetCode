package com.offer.offer37;

import com.leetcode.datastructure.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String res = root.val + "_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.add(values[i]);
        }
        return reco(queue);
    }
    public TreeNode reco(Queue<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reco(queue);
        head.right = reco(queue);
        return head;
    }
}
