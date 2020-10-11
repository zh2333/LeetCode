package com.leetcode.p938;

import com.leetcode.datastructure.TreeNode;

/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * 二叉搜索树保证具有唯一的值。
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        inOrder(root, L, R);
        return sum;
    }

    public void inOrder(TreeNode root, int l, int r) {
        if(root == null) return;

        inOrder(root.left, l, r);
        if(root.val >= l && root.val <= r) {
            sum += root.val;
        }
        inOrder(root.right, l, r);
    }
}
