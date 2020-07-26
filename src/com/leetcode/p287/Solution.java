package com.leetcode.p287;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
	示例 1:
	输入: [1,3,4,2,2]
	输出: 2
	示例 2:
	输入: [3,1,3,4,2]
	输出: 3
	说明：
	不能更改原数组（假设数组是只读的）。
	只能使用额外的 O(1) 的空间。
	时间复杂度小于 O(n2) 。
	数组中只有一个重复的数字，但它可能不止重复出现一次。
	 * @author 张恒
 *	解决:快慢指针法
 */
class Solution {
    public int findDuplicate(int[] nums) {
    	int fast = 0;
    	int slow = 0;
    	while(true){
    		fast = nums[nums[fast]];
    		slow = nums[slow];
    		if(fast == slow){
    			break;
    		}
    	}
    	int finder = 0;
    	while(true){
    		finder = nums[finder];
    		slow = nums[slow];
    		if(finder == slow){
    			break;
    		}
    	}
    	return finder;
    }
}