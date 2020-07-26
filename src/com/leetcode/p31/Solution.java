package com.leetcode.p31;

/**
 * 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
	如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
	必须原地修改，只允许使用额外常数空间。
	以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
	1,2,3 → 1,3,2			
	3,2,1 → 1,2,3
	1,1,5 → 1,5,1
 * @author 张恒
 *
 */
public class Solution {
	public static void nextPermutation(int[] nums) {
		int len = nums.length -1;
		int i = len -1;
		int j = len;
		while(i>=0 && nums[i] >= nums[i+1]) i--;
		if(i>=0){
			while(j>=0 && nums[j]<=nums[i]) j--;
			swap(nums, i, j);
		}
		reverse(nums, i+1);
    }
	
	
	public  static void reverse(int[] nums,int start){
		int end = nums.length-1;
		while(start < end){
			swap(nums, start, end);
			start++;
			end--;
		}
	}
	
	public static void swap(int[] nums,int i,int j){
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}
