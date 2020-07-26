package com.leetcode.p136;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @author 张恒
 *解决:异或运算.
 *
 */
public class Solution {
	public static void main(String[] args) {
		int[] test = {4,1,2,1,2};
		System.out.println(singleNumber(test));
	}
    public static int singleNumber(int[] nums) {
    	int ans = 0;
    	for (int num : nums) {
			ans ^=num;
		}
		return ans;
    }
}