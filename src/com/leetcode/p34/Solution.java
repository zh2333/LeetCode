package com.leetcode.p34;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
	你的算法时间复杂度必须是 O(log n) 级别。
	如果数组中不存在目标值，返回 [-1, -1]。
 * @author 张恒
 *
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
    	int len = nums.length;
    	if(nums.length == 0 || nums[0]>target||nums[len-1]<target){
    		int[] result={-1,-1};
    		return result;
    	}
    	
    	int firstIndex=-1;
    	int lastIndex=-1;
    	
    	int left = 0;
    	int right = len-1;
    	
    	//找最先出现的位置
    	while(left<=right){
    		int mid = left + (right-left)/2;
    		if(target < nums[mid]){
    			//在左边,更新右指针
    			right = mid -1 ;
    		}else if(target > nums[mid]){
    			//在右边,更新左指针
    			left = mid+1;
    		}else{
    			//匹配到了,此时不一定是最前面的.你得确保这个匹配到的数字的前一个数小于这个数字才可以
    			if(mid == 0 || nums[mid - 1] < target){
    				firstIndex = mid;
    				break;
    			}else{
    				//前面还可能存在,缩小区间,更新右指针
    				right = mid -1;
    			}
    		}
    	}
    	
    	//重置左右指针,搜索最后出现的位置
    	left =0;
    	right = len-1;
    	
    	//找最后出现的位置
    	while(left<=right){
    		int mid = left + (right-left)/2;
    		if(target < nums[mid]){
    			//在左边,更新右指针
    			right = mid -1 ;
    		}else if(target > nums[mid]){
    			//在右边,更新左指针
    			left = mid+1;
    		}else{
    			//匹配到了,此时不一定是最后面的.你得确保这个匹配到的数字的后一个数大于这个数字才可以
    			if(mid == len-1 || nums[mid + 1] > target){
    				lastIndex = mid;
    				break;
    			}else{
    				//后面还可能存在,缩小区间,更新左指针
    				left = mid+1;
    			}
    		}
    	}
    	
    	int[] result ={firstIndex,lastIndex};
    	return result;
    	
    }
}