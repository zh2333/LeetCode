	package com.leetcode.p448;
	
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;
	
	/**
	 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
		找到所有在 [1, n] 范围之间没有出现在数组中的数字。
		您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
		示例:
		输入:
		[4,3,2,7,8,2,3,1]
		输出:
		[5,6]
	 *
	 */
	public class Solution {
		public static void main(String[] args) {
			int[] nums = {4,3,2,7,8,2,3,1};
			List<Integer> list = findDisappearedNumbers(nums);
			for (Integer t : list) {
				System.out.print(t+" ");
			}
	    	
		}
	    public static List<Integer> findDisappearedNumbers(int[] nums) {
	    	if(nums == null) return new ArrayList();
	    	List<Integer> list = new ArrayList();
	    	Arrays.sort(nums);
	    	
	    	//
	    	for (int i = 0; i < nums.length; i++) {
	    		int index = Math.abs(nums[i])-1;
				if(nums[index]>0) {
					nums[index] *= -1;
				}
	    	
	 		}
	    	
	    	//第二次循环找到缺失的元素
	    	for (int i = 0; i < nums.length; i++) {
				if(nums[i] > 0){
					list.add(i+1);
				}
			}
	    	return list;
	    }
	}