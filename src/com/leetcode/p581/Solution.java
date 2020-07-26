package com.leetcode.p581;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
	你找到的子数组应是最短的，请输出它的长度。
	示例 1:
	输入: [2, 6, 4, 8, 10, 9, 15]
	输出: 5
	解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

 * 
 * @author 张恒
 *	同时从前往后和从后往前遍历，分别得到排序数组的右边界和左边界；
	寻找右边界：从前往后遍历的过程中，用max记录遍历过的最大值，如果max大于当前的nums[i]，说明nums[i]的位置不正确，
	应该属于需要排序的数组，因此将右边界更新为i，然后更新max；这样最终可以找到需要排序的数组的右边界，右边界之后的元素都大于max；
	寻找左边界：从后往前遍历的过程中，用min记录遍历过的最小值，如果min小于当前的nums[j]，说明nums[j]的位置不正确，
	应该属于需要排序的数组，因此将左边界更新为j，然后更新min；这样最终可以找到需要排序的数组的左边界，左边界之前的元素都小于min；
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
    	int len = nums.length;
    	int max = nums[0];
    	int min = nums[len-1];
    	int leftEdge = 0;
    	int rightEdge = -1;
    	
    	for (int i = 0; i < len; i++) {
			//更新右边,从前往后遍历
    		if(max > nums[i]){
    			rightEdge = i;
    		}else{
    			max = nums[i];
    		}
    		int t = len-1-i;
    		if (min < nums[t]) {
				leftEdge = t;
			}else{
				min = nums[t];
			}
		}
    	
    	return rightEdge-leftEdge+1;
    }
}