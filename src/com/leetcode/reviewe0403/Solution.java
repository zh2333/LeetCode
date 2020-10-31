package com.leetcode.reviewe0403;


import com.leetcode.datastructure.ListNode;
import com.leetcode.datastructure.TreeNode;
import com.leetcode.utils.MyList;
import com.leetcode.utils.MyTree;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    @Test
    public void test() {
        TreeNode root = MyTree.generateBST(10);
        MyTree.show(root);
        ListNode[] nodes = listOfDepth(root);

        for (ListNode node:nodes) {
            MyList.printList(node);
        }
    }
    public ListNode[] listOfDepth(TreeNode tree) {
        List<List<Integer>> nodes = levelFind(tree);

        ListNode[] firstNodes = new ListNode[nodes.size()];

        int i = 0;
        for (List<Integer> level: nodes) {
            firstNodes[i++] = toBeList(level);
        }
        return firstNodes;
    }

    public List<List<Integer>> levelFind(TreeNode root) {
        if (root == null) return new LinkedList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            int size = nodes.size();//当前层的节点数目

            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = nodes.poll();
                level.add(currNode.val);
                if (currNode != null && currNode.left != null) nodes.add(currNode.left);
                if (currNode != null && currNode.right != null) nodes.add(currNode.right);
            }
            res.add(level);
        }
        return res;
    }

    /**
     * 将一层的节点转换为一个链表
     * @param level
     * @return
     */
    public ListNode toBeList (List<Integer> level) {
        int size = level.size();
        if (size == 0) return null;
        ListNode first = null;
        ListNode tmp = null;
        for (Integer val: level) {
            ListNode curr = new ListNode(val);
            if (first == null) {
                first = curr;
                tmp = curr;
            } else {
                tmp.next = curr;
                tmp = tmp.next;
            }
        }
        return first;
    }
}
