package com.leetcode.p139;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
	说明：
	拆分时可以重复使用字典中的单词。
	你可以假设字典中没有重复的单词。
	示例 1：
	输入: s = "leetcode", wordDict = ["leet", "code"]
	输出: true
	解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
	示例 2：
	输入: s = "applepenapple", wordDict = ["apple", "pen"]
	输出: true
	解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
	     注意你可以重复使用字典中的单词。
	示例 3：
	输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
	输出: false
 * @author 张恒
 *	解决:
 *	动态规划:字符串是由子字符串拼接的,如果子字符串能够在字典中匹配到,那么继续匹配,如果子字符串都能够早字典中匹配到,呢么说明
 *			可以拆分
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
    	Set<String> word_Dict = new HashSet(wordDict);
    	int len = s.length();
    	boolean dp[] = new boolean[len+1];
    	dp[0] = true;
    	
    	//匹配字典中的哪一个单词片段
    	for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				//看是否能够在s中匹配的到,如果上一个片段能匹配得到,并且本次能匹配得到,跳过这个片段,匹配下一个片段
				if(dp[j] && word_Dict.contains(s.substring(j,i))){
					dp[i] = true;
					break;
				}
			}
		}
    	return dp[len];
    }
}
