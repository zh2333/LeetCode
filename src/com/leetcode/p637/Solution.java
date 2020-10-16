package com.leetcode.p637;


import com.leetcode.datastructure.ListNode;
import com.leetcode.datastructure.TreeNode;
import com.leetcode.utils.MyList;
import com.leetcode.utils.MyTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * 示例 1：
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    @Test
    public void test() {
        TreeNode root = MyTree.generateBST(5);
        MyTree.show(root);
        List<Double> res = averageOfLevels(root);
       // MyList.printList(res.get(0));
    }
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Double> res = new LinkedList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int size;
        while(!nodes.isEmpty()) {
            List<TreeNode> level = new LinkedList<>();
            size = nodes.size();//当前层的节点数
            Double levelSum = 0.0;//当前层的节点数值之和
            for (int i = 0; i < size; i++) {
                TreeNode currNode = nodes.poll();
                levelSum += Double.valueOf(currNode.val);
                if(currNode!=null && currNode.left != null) nodes.add(currNode.left);
                if(currNode!=null && currNode.right != null) nodes.add(currNode.right);
            }
            String levelStr = String.format("%.5f", levelSum / size);
            Double levelRes = Double.parseDouble(levelStr);
            System.out.println(levelRes);
            res.add(levelRes);
        }
        return res;
    }
}
