package com.leetcode.p530;

import com.leetcode.datastructure.TreeNode;
import com.leetcode.utils.MyTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    @Test
    public void test() {
        TreeNode root = MyTree.generateBST(5);
        MyTree.show(root);
        int min = getMinimumDifference(root);
        System.out.println("min: " + min);
    }
    public int getMinimumDifference(TreeNode root) {
        if(root == null) {
            return 0;
        }
        List<Integer> nodes = new ArrayList<>();
        helper(root, nodes);

        int len = nodes.size();
        int min = nodes.get(len - 1);
        for (int i = len - 1; i >= 1 ; i--) {
            int tmp = nodes.get(i) - nodes.get(i - 1);
            min = min < tmp ? min : tmp;
        }
        return min;
    }

    public void helper(TreeNode root, List<Integer> nodes) {
        if(root.left != null) {
            helper(root.left, nodes);
        }
        nodes.add(root.val);
        if(root.right  != null ) {
            helper(root.right, nodes);
        }
    }

}
