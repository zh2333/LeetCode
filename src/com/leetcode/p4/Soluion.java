package com.leetcode.p4;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
 * @author 张恒
 *	解决:合并再排序
 */
class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int[] nums = new int[nums1.length + nums2.length];
    	int len1 = nums1.length;
    	int len2 = nums2.length;
    	int len = len1+len2;
    	for (int i = 0;i < len; i++){
            if (i < len1) nums[i] = nums1[i];
            else nums[i] = nums2[i-len1];
        }
    	return getMidValue(nums);
    }
    public double getMidValue(int[] nums){
    	Arrays.sort(nums);
    	int len = nums.length;
    	if(len % 2 == 0){
    		return ((double)nums[len/2]+(double)nums[len/2-1])/2;
    	}else{
    		return (double)nums[len/2];
    	}
    }
}