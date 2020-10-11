package com.leetcode.p897;

import com.leetcode.datastructure.TreeNode;
import com.leetcode.utils.MyTree;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * 示例 ：
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    @Test
    public void test() {
        TreeNode root = MyTree.generateBST(6);
        MyTree.show(root);
        root = increasingBST(root);
        MyTree.show(root);
    }
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        List<TreeNode> nodeList = new LinkedList<>();
        inOrder(root, nodeList);
        int size = nodeList.size() - 1;
        for (int i = 0; i < size ; i++) {
            nodeList.get(i).left = null;
            nodeList.get(i).right = nodeList.get(i+1);
        }
        for (TreeNode node:nodeList
             ) {
            System.out.println(node.val);
        }
        return nodeList.get(0);
    }

    public void inOrder(TreeNode node, List<TreeNode> res) {
        if(node == null) return;
        if(node.left != null) {
            inOrder(node.left,res);
        }
        res.add(node);
        if(node.right != null) {
            inOrder(node.right,res);
        }
    }
}
