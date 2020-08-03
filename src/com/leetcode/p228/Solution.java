package com.leetcode.p228;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.leetcode.utils.Array;

/**
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
	示例 1:
	输入: [0,1,2,4,5,7]
	输出: ["0->2","4->5","7"]
	解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
	示例 2:
	
	输入: [0,2,3,4,6,8,9]
	输出: ["0","2->4","6","8->9"]
	解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/summary-ranges
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张恒
 *
 */
public class Solution {
	@Test
	public void dupTest() {
		int wrong = 0;
		int len = 0;
		for(int i = 0; i < 10000;i ++) {
			len = (int)(Math.random() * 20);
			try{
				test(len);
			} catch(Exception e) {
				wrong++;
			}
		}
		System.out.println("出错次数: " + wrong);
	}
	
	
	public void test(int len) {
		int[] nums = Array.generateArray(len);
		List<String> res = new ArrayList<>();
		res = summaryRanges(nums);
		int i = 0;
		while(i < res.size()) {
			System.out.print(res.get(i) + " ");
			i++;
		}
		System.out.println();
	}
	public List<String> summaryRanges(int[] nums) {
		int len = nums.length;
		if(len == 0) return new ArrayList<String>();
		int end = 0;
		int start = 0;
		List<String> res = new ArrayList<>();
		while(start < len) {
			end = continuousSequence(nums, len, start);
			if(start < len) {
				putIntoList(nums, start, end, res);
			} else {
				start = end;
				putIntoList(nums, start, end, res);
			}
			start = end + 1;
		}
		
		return res;
    }
	
	/**
	 * 找到连续子数组
	 * @param nums
	 * @param start
	 * @return 连续子数组的endIndex  
	 */
	public int continuousSequence(int[] nums, int len, int start) {
		while(start < len - 1) {
			if(nums[start] + 1 != nums[start+1]) {
				break;
			} else {
				start++;
			}
		}
		return start;
	}
	
	public void putIntoList(int[] nums, int start, int end, List<String> res) {
		StringBuilder sub = new StringBuilder();
		if(start != end) {
			sub.append(nums[start]).append("->").append(nums[end]);
		} else {
			sub.append(nums[start]);
		}
		res.add(sub.toString());
	}
}
