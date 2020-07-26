package com.leetcode.p78;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
	说明：解集不能包含重复的子集。
	示例:
	输入: nums = [1,2,3]
	输出:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]

 * @author 张恒
 *	解决:
 *	第1个问号处，1<<nums.length 等价于 2^nums.length,对于n个数字的数组，共2^n个子集；

第2个问号处，以0~(2^n)-1，2^n个n位二进制数，对应于所有子集，从后往前第 j 个二进制位为 0 表示不放入第 j 个元素,同理1表示放入。" ((i >> j) & 1) == 1 " 表示对于二进制数i，从低位到高位逐个取其二进制位，并判断是否为1，若为1则放入对于nums中的元素。

Tip：如nums={1,2,3},i=6,三位二进制为110，则对应子集 {2,3}
    1 2 3
    0 0 0  空集
    0 0 1  {3}
    0 1 0  {2}
    0 1 1  {2,3}
    1 0 0  {1}
    1 0 1  {1,3}
    1 1 0  {1,2}
    1 1 1  {1,2,3}
 */
public class Solution {
	 public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        int n = 1<<len;
        //0-7这八个数字换算成二进制正好可以表示8个子集.每个子集所对应的bit位0,1情况是不一样的
        for (int i = 0; i < n; i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < len; j++)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            res.add(sub);
        }
        return res;
    }
}
