package com.offer.面试题59;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


 * @author 张恒
 *
 */
class Solution {
	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int[] result = maxSlidingWindow(nums, 3);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]+" ");
		}
		
	}
    public static int[] maxSlidingWindow(int[] nums, int k) {
       int[] result = new int[nums.length - k + 1];
       for (int i = 0,j = 0; i <= nums.length - k; i++,j++) {
    	   int currMax = nums[i];
    	   for (int j2 = i+1; j2 < i + k; j2++) {
    		   currMax = currMax > nums[j2] ? currMax : nums[j2];
    	   }
    	   result[i] = currMax;
       }
       return result;
    }
}