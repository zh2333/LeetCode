package com.leetcode.p647;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
	具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
	示例 1:
	输入: "abc"
	输出: 3
	解释: 三个回文子串: "a", "b", "c".
	示例 2:
	
	输入: "aaa"
	输出: 6
	说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * @author 张恒
 *	解决:
 *	每次到达一个新的字符就从这个字符开始向左右扩散
 *	回文串有两种形式:
 *  1.yxy
 *  1.yxxy
 * 因此在此基础上还要再分两种情况
 *  
 *  */
class Solution {
	
    public int countSubstrings(String s) {
		int result = 0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			result += count(s,i,i);//yxy形式,left=right,从同一点开始向两边扩散
			result += count(s,i,i+1);//yxxy形式,right = left+1,从相邻两点向两边扩散
		}
		return result;
	}
    
    public static int count(String s,int left,int right){
    	int count = 0;
    	while(left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)){
    		count++;
    	}
		return count;
    }   
}
