package com.leetcode.p215;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
	示例 1:
	输入: [3,2,1,5,6,4] 和 k = 2
	输出: 5
	示例 2:
	输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
	输出: 4
 * @author 张恒
 *	解决:
 *	先排序,再取排序后数组的倒数第K个元素
 *	因此,本题的关键是手写一个快排或者是堆排序
 */


class Solution{
	public static void main(String[] args) {
		int[] nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
		findKthLargest(nums, 2);
		for (int i : nums) {
			System.out.print(i+" ");
		}
	}
	public static int findKthLargest(int[] nums, int k) {
		int len = nums.length;
		if(len== 0) return 0;

		int left = 0;
		int right = len - 1;
		quickSort(nums, left, right);
		return nums[len - k];
    }
	
	public static void quickSort(int[] nums,int left,int right){
		int tmp;
		int i = left;
		int j = right;
		if(left < right){
			tmp = nums[left];
			while(i<j){
				//从右边开始找,找到一个比tmp小的,交换位置
				while(i<j && tmp <= nums[j]) --j;
				if(i < j){
					nums[i] = nums[j];
					++i;
				}
				//从左边开始找,找到一个比tmp大的数,交换位置
				while(i < j && tmp > nums[i]) ++i;
				if(i < j){
					nums[j] = nums[i];
					--j;
				}
			}
			nums[i] = tmp;
			quickSort(nums, left, i-1);
			quickSort(nums, i+1, right);
		}
	}
}

