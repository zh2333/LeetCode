package com.leetcode.p189;

import org.junit.Test;

import com.leetcode.utils.Array;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

	示例 1:
	
	输入: [1,2,3,4,5,6,7] 和 k = 3
	输出: [5,6,7,1,2,3,4]
	解释:
	向右旋转 1 步: [7,1,2,3,4,5,6]
	向右旋转 2 步: [6,7,1,2,3,4,5]
	向右旋转 3 步: [5,6,7,1,2,3,4]
	示例 2:
	
	输入: [-1,-100,3,99] 和 k = 2
	输出: [3,99,-1,-100]
	解释: 
	向右旋转 1 步: [99,-1,-100,3]
	向右旋转 2 步: [3,99,-1,-100]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/rotate-array
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张恒
 *
 */
public class Solution {
	@Test
	public void dupTest() {
		int wrong = 0;
		for(int i = 0;i < 100;i++) {
			try{
				int k = (int)(Math.random() * 10);
				test(k);
			} catch (Exception e) {
				wrong++;
			}
		}
		System.out.println("出错次数:" + wrong);
	}
	
	
	public void test(int k) {
		System.out.println("右移: " + k + "次");
		int[] array = Array.generateArray(12);
		Array.printArray(array);
		rotate(array, k);
		Array.printArray(array);
	}
	public void rotate(int[] nums, int k) {
        int len = nums.length;
       
        int steps = k % len;
        if(steps == 0) return;
        
        int position = len - steps;
        for(int i = position; i < len ; i++) {
        	int wannerPosition = (i + steps) % len; // wannerPosition < position
        	goToWannner(nums, i, wannerPosition);
        } 
    }
	
	public void goToWannner(int[] nums, int currPosition, int wannerPosition) {
		int tmp = nums[currPosition];
		for(int i = currPosition; i > wannerPosition; i--) {
			nums[i] = nums[i - 1];
		}
		nums[wannerPosition] = tmp;
	}
}
