package com.leetcode.p49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
	示例:
	输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
	输出:
	[
	  ["ate","eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	说明：
	
	所有输入均为小写字母。
	不考虑答案输出的顺序。

 * @author 张恒
 *
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    	if(strs == null) return new ArrayList();
    	
    	//创建映射
    	Map<String,List> ans = new HashMap<String,List>();
    	for (String str : strs) {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			String key = String.valueOf(c);
			if(!ans.containsKey(key)){
				//将键存入集合中
				ans.put(key, new ArrayList());
			}
			//将相同字母的字符串存入同一个list中
			ans.get(key).add(str);
		}
    	//将hashMap中的value取出来放进另一个集合
    	return new ArrayList(ans.values());
    }
}