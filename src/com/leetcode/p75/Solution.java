package com.leetcode.p75;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
	此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
	注意:
	不能使用代码库中的排序函数来解决这道题。
	示例:
	输入: [2,0,2,1,1,0]
	输出: [0,0,1,1,2,2]
 * @author 张恒
 *	荷兰国旗问题:
 *将原数组分成三个部分,用三个指针来分别追踪这三个部分的变化
 */

public class Solution {
    public void sortColors(int[] nums) {
    	int len = nums.length;
    	if(len < 2) return;
    	
    	int zero = -1;
    	int i = 0;
    	int two = len - 1;
    	
    	while(i <= two){
    		//如果遇到的是0就将0交换到零区域
    		if(nums[i] == 0){
    			zero++;
    			swap(nums,i,zero);
    			i++;
    		}else if(nums[i] == 1){
    			//如果遇到的是1不作任何改变
    			i++;
    		}else{
    			//如果遇到的是2就将该数字交换到二区域
    			swap(nums,i,two);
    			two--;
    		}
    	}
    }
    
    public static void swap(int[] array,int i,int j){
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
}
