package com.offer.面试题21;

class Solution {
    public int[] exchange(int[] nums) {
    	int i = 0;
    	int j = nums.length;
    	
    	while(i < j){
    		while(i < j && nums[i] % 2 == 1) ++i;//从前找到偶数
    		while(i < j && nums[j] % 2 == 0) --j;//从后找到奇数
    		if(i < j){
    			swap(nums,i,j);
    		}
    		++i;
    		--j;
    	}
    	return nums;
    }
    
    public static void swap(int[] nums,int i,int j){
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}