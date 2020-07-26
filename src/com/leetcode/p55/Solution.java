package com.leetcode.p55;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
	数组中的每个元素代表你在该位置可以跳跃的最大长度。
	判断你是否能够到达最后一个位置。
	示例 1:
	输入: [2,3,1,1,4]
	输出: true
	解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
	示例 2:
	输入: [3,2,1,0,4]
	输出: false
	解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * @author 张恒
 *	
 *	 k是i之前所有节点能到的最远地方，如果i>k，那不就说明前面没有任何节点能到达i节点吗？这样根本没法往后走了，所以是false
 *	1.用maxDistence表示该点之前的点能到达的最远索引如果maxDistance<index,表明该点不可达,其后的索引也不可达
 *	2.如果maxDistance>=index,尝试更新maxDistance,用index+nums[i](表示该点能到达的最远距离),和maxDistance比较
 */
class Solution {
    public boolean canJump(int[] nums) {
		int len = nums.length;
		int maxDistance = 0;
		for (int i = 0; i < len; i++) {
			if(i > maxDistance) return false;
			maxDistance = Math.max(maxDistance, i+nums[i]);
		}
		return true;
    }
}
