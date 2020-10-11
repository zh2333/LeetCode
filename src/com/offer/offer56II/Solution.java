package com.offer.offer56II;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

 

示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1
 

限制：

1 <= nums.length <= 10000
1 <= nums[i] < 2^31
 * @author 张恒
 *
 */
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0;i < len;i++){
        	if(map.containsKey(nums[i])){
        		map.put(nums[i], map.get(nums[i])+1);
        	}else {
        		map.put(nums[i],1);
        	}
        }
        int result = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        	if(entry.getValue()==1){
        		result = entry.getKey();
        	}
        }
        return result;
    }
}
