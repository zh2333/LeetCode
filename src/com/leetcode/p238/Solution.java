package com.leetcode.p238;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
	示例:
	输入: [1,2,3,4]
	输出: [24,12,8,6]
 * @author 张恒
 *	解决:当前位元素的位置的值=其左边元素的乘积*其右边元素的乘积
 *
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
    	int len = nums.length;
    	int[] ans = new int[len];
    	int tmp = 1;//用于累乘左边或者右边的元素
    	//计算出每一位左边元素的乘积
    	for (int i = 0; i < len; i++) {
			ans[i] = tmp;//把第i位的元素设置为其左边元素的乘积
			tmp *= nums[i];//更累乘变量新
		}
    	tmp = 1;
    	for (int i = len - 1; i >= 0; i--) {
			ans[i] *= tmp;//tmp表示第i个元素左边的累乘值,ans[i]表示左边的累乘值,因此要将两者相乘
			tmp *= nums[i];//更新累乘变量
		}
		return ans;
    }
}