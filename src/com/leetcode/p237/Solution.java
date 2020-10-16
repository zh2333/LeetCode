package com.leetcode.p237;

import com.leetcode.datastructure.TreeNode;
import com.leetcode.utils.MyTree;
import com.leetcode.utils.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    @Test
    public void test() {
        TreeNode root = MyTree.generateBST(8);
        MyTree.show(root);
        List<String> res = binaryTreePaths(root);
        for (String str:res) {
            StringUtil.printStr(str);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<>();
        ArrayList<String> paths = new ArrayList<>();
        String path = "";
        helper(root, paths, path);
        return paths;
    }

    public void helper(TreeNode root, List<String> paths, String path) {
        path += String.valueOf(root.val);
        if(root.left == null && root.right == null) {
            paths.add(path);
        } else {
            path += "->";
            if(root.left != null) helper(root.left, paths, path);
            if(root.right != null) helper(root.right, paths, path);
        }
    }
}
