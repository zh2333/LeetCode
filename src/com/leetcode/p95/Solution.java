package com.leetcode.p95;

import com.leetcode.datastructure.TreeNode;
import com.leetcode.utils.MyArray;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private  TreeNode root = null;
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<TreeNode> outPut = new LinkedList<>();
    private int n;
    private int k;

    public  List<TreeNode> generateTrees(int n) {
        int size = res.size();
        res = combine(n,n);
        for (int i = 0; i < size; i++) {
            LinkedList<Integer> currList = (LinkedList<Integer>) res.get(i);
            int tmpSize = currList.size();
            for (int j = 0; j < tmpSize; j++) {
                insert(currList.get(i));
            }
            outPut.add(root);
            root = null;
        }
        return outPut;
    }
    private  void insert(int val) {
        TreeNode currNode = new TreeNode(val);
        if(root == null) {
            root = currNode;
        } else {
            TreeNode parent = new TreeNode(-1);
            TreeNode currRoot = root;

            while(true) {
                parent = currRoot;
                if(val >= currRoot.val) {//当前节点值大于等于当前根节点值
                    currRoot = currRoot.right;
                    if(currRoot == null) {
                        parent.right = currNode;
                        break;
                    }
                } else {//当前节点值小于根节点值
                    currRoot = currRoot.left;
                    if(currRoot == null) {
                        parent.left = currNode;
                        break;
                    }
                }
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrace(1, new LinkedList<Integer>());
        return res;

    }

    public void backtrace(int first, LinkedList<Integer> curr) {
        if(curr.size() == k) {
            res.add(new LinkedList<>(curr));
        }

        for (int i = first; i <= n ; ++i) {
            curr.add(i);
            backtrace(i + 1, curr);
            curr.removeLast();
        }
    }
}
