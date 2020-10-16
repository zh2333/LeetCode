package com.leetcode.p783;

import com.leetcode.datastructure.TreeNode;
import com.leetcode.utils.MyTree;
import org.junit.Test;

/**
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 * 示例：
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    Integer min = Integer.MAX_VALUE;
    TreeNode pre = null;

    @Test
    public void test() {
        TreeNode root = MyTree.generateBST(4);
        MyTree.show(root);
        System.out.println(minDiffInBST(root));
    }
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return min;
    }

    public void helper(TreeNode root) {
        if(root == null) return;

        helper(root.left);
        if(pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        helper(root.right);
    }


}
