package com.leetcode.p41;

import com.leetcode.utils.Array;

public class Solution {
	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		if(len == 0) return 1;
		
		//将i位置处的元素交换到nums[i] - 1处的位置， 如果两个位置处的元素值相等则无需交换
		for(int i = 0; i < len; i++) {
			while(nums[i] > 0 && nums[i] < len && nums[i] != nums[nums[i] - 1]) {
				Array.swap(nums, i, nums[i] - 1);
			}
		}
		
		//从头开始 遍历， 如果当前位置i出的元素和nums[i] 不满足关系 nums[i] - 1 = i, 则表明当前位置i+1这个元素是缺失的
		for(int i = 0; i < len ; i++) {
			if(nums[i] != i + 1) {
				return i + 1;
			}
		}
		//说明所有元素都在其应该在的位置
		return len + 1;
    }

}
