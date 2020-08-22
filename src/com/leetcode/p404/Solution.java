package com.leetcode.p404;

import com.leetcode.datastructure.TreeNode;
import com.leetcode.utils.MyTree;
import org.junit.Test;

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    int sum = 0;

    @Test
    public void test() {
        TreeNode root = MyTree.generateBST(8);
        MyTree.show(root);
        System.out.println(sumOfLeftLeaves(root));
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return sum;
        sum += root.left == null ? 0 : ((root.left.left == null && root.left.right == null) ? root.left.val: 0);
        if(root.left != null) sumOfLeftLeaves(root.left);
        if(root.right != null) sumOfLeftLeaves(root.right);
        return  sum;
    }
}
