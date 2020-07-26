package com.leetcode.p33;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
	( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
	搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
	你可以假设数组中不存在重复的元素。
	你的算法时间复杂度必须是 O(log n) 级别。
	来源：力扣（LeetCode）
 * @author 张恒
 *
 */
class Solution {
    public int search(int[] nums, int target) {
    	if(nums == null || nums.length == 0) return -1;
    	
    	int left = 0;
    	int right = nums.length - 1;
    	int mid;
    	
    	
		while(left<=right){
//			mid = (left+right)/2;
			mid = left+(right-left)/2;//防止right和left相差太大,加起来溢出
			if(nums[mid] == target) return mid;
			//左半部分是有序的且为升序
			if(nums[left] <= nums[mid]){
				//还在左边,右指针=mid-1
				if(target >=nums[left] && target <=nums[mid]){
					right = mid -1;
				}else{
					//target在右半部分,无序,left改变为右边
					left = mid + 1;
				}
			}else{
				//右边部分有序
				if(target >=nums[mid] && target<=nums[right]){
					left = mid + 1;
				}else{
					right = mid - 1;
				}
			}
		}
		
		return -1;
    }
}