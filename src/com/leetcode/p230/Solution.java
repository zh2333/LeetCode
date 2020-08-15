package com.leetcode.p230;

import com.leetcode.datastructure.TreeNode;
import com.leetcode.utils.MyTree;
import org.junit.Test;

import java.util.HashSet;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private static HashSet<Integer> set = new HashSet<>();
    private static TreeNode  res = null;
    @Test
    public void test() {
        TreeNode root  = MyTree.generateBST(9);
        MyTree.middleFind(root);
        System.out.println();
        int val = kthSmallest(root ,1);
        System.out.println(val);
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        middle(root, k);
        if(res != null) {
            return res.val;
        }
        return 0;
    }

    public void middle(TreeNode currroot , int k) {
        if(currroot.left != null) {
            middle(currroot.left, k);
        }
        set.add(currroot.val);
        if (set.size() == k) {
            if(res == null) {
                res = currroot;
            }
            return;
        }
        if(currroot.right != null) {
            middle(currroot.right, k);
        }
    }

}
