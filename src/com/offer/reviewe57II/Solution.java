package com.offer.reviewe57II;

import java.util.ArrayList;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 

示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * @author 张恒
 *解决:
 *滑动窗口
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
    	int i = 1;
    	int j = 1;
    	int sum = 0;
    	ArrayList<int[]> res = new ArrayList<int[]>();
    	
    	while(i <= target / 2){
    		//1.如果和小于target,右边界向右移动,增大值
    		if(sum < target){
    			sum += j;
    			j++;
    		}else if(sum > target){
    			//2.如果和大于target,左边界向右移动,减小值
    			sum -= i;
    			i++;
    		}else{
    			//3.值相等就将结果存到数组中
    			int[] ans = new int[j-i];
    			for (int k = i; k < j; k++) {
					ans[k - i] = k;
				}
    			res.add(ans);
    			//移动窗口左边界
    			sum -= i;
    			i++;
    		}
    	}
    	return res.toArray(new int[res.size()][]);
    	
    }
}