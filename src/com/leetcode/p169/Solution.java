package com.leetcode.p169;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
	你可以假设数组是非空的，并且给定的数组  总是  存在多数元素。
 * @author 张恒
 * 
 */
public class Solution {
    public int majorityElement(int[] nums) {
    	int count = nums.length/2;
    	
    	Arrays.sort(nums);
    	
    	
		return nums[nums.length/2];

    }
}