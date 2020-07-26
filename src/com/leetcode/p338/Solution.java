package com.leetcode.p338;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
	示例 1:
	输入: 2
	输出: [0,1,1]
	示例 2:
	输入: 5
	输出: [0,1,1,2,1,2]
 * @author 张恒
 * 解决:时间复杂度要求是o(n),使用动态规划
 * 分析:
 *	0  1  2  3  4  5  6  7  8   
 *  0  1  1  2  1  2  2  3  1
 *  -------------------------
 *  发现:
 *  一个数x
 *  如果x是偶数,则它的一的个数等于[x/2]的一的个数
 *  如果x是奇数,则它的一的个数等于[x/2]的一的个数+1
 *  (向下取整)
 * 
 */
class Solution {
    public int[] countBits(int num) {
    	int[] dp = new int[num+1];
    	for (int i = 0; i <= num; i++) {
			int d = i/2;
			int m = i%2;
			if(m == 0){
				//偶数
				dp[i] = dp[d];
			}else{
				//奇数
				dp[i] = dp[d]+1;
			}
		}	
	return dp;
    }
}
