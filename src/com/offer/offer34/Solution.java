package com.offer.offer34;

import com.leetcode.datastructure.TreeNode;
import com.leetcode.utils.MyList;
import com.leetcode.utils.MyTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(-2);
        TreeNode node4 = new TreeNode(-3);

        node1.right = node4;
        MyTree.show(node1);
        List<List<Integer>> res = pathSum(node1, -5);
    }



    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        int currSum = 0;
        helper(root, res, path, currSum, sum);
        return res;
    }

    public void helper(TreeNode root, List<List<Integer>> paths, LinkedList<Integer> path, int currSum, int sum) {
        currSum = currSum + root.val;
        path.add(root.val);
        if(currSum == sum && root.left == null && root.right == null) {
            paths.add(new LinkedList<>(path));
        } else if(currSum < sum){
            if(root.left != null) helper(root.left, paths, path, currSum, sum);
            if(root.right != null) helper(root.right, paths, path, currSum, sum);
        }
        path.removeLast();
    }
}
