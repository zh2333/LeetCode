package com.leetcode.utils;

import com.leetcode.datastructure.TreeNode;
import org.junit.Test;

public class MyTree {
    private static TreeNode root = null;

    @Test
    public  void test() {
        TreeNode root = generateBST(8);
        middleFind(root);
    }
    /**
     * 生成一棵二叉搜索树
     * @param count 数的节点的数量
     * @return
     */
    public static TreeNode generateBST(int count) {

        if(count == 0) {
            System.out.println("不能为空树!");
        }
        int[] arr = MyArray.generateArray(count);
        for (int i = 0; i < count; i++) {
            insert(arr[i]);
        }
        return root;
    }
    private static void insert(int val) {
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

    public static void middleFind(TreeNode root) {
        if(root.left != null) {
            middleFind(root.left);
        }
        if(root != null) {
            System.out.print(root.val+" ");
        }
        if(root.right != null) {
            middleFind(root.right);
        }
    }

}
