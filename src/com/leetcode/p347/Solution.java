package com.leetcode.p347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
	示例 1:
	输入: nums = [1,1,1,2,2,3], k = 2
	输出: [1,2]
	示例 2:
	输入: nums = [1], k = 1
	输出: [1]
	说明：
	你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
	你的算法的时间复杂度必须优于 O(nlog n) , n 是数组的大小。
 * @author 张恒
 *	解决:
 *	1.先统计每个字符出现的次数并按照从大到小的顺序排序
 *	2.按照频度将不同的字符分类,每个频度的字符存放在一个list中
 *	3.提取list中前k个频度的字符
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> res = new ArrayList();
    	Map<Integer,Integer> ans = new HashMap<>();
    	//获取每个字符出现的个数,并按照由高到低排序
    	for (int i : nums) {
			ans.put(i, ans.getOrDefault(i, 0)+1);
		}
    	
    	//list是一个数组数组元素时一个个的列表
    	List<Integer>[] list = new List[nums.length+1];
    	//按照出现次数将字符归类
    	for (int key: ans.keySet()) {
			int count = ans.get(key);
			if(list[count] == null) {
				list[count] = new 	ArrayList();
			}
			list[count].add(key);
		}
    	
    	for (int i = list.length - 1; i >= 0 && res.size() < k ; i--) {
    		if(list[i] == null) continue;
    		res.addAll(list[i]);
			
		}
		return res;
        
    }
}
