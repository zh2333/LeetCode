package com.leetcode.p409;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
	在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
	注意:
	假设字符串的长度不会超过 1010。
	示例 1:
	输入:
	"abccccdd"
	输出:
	7
	解释:
	我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * @author 张恒
 *	解决:统计每个字符出现的次数,如果是偶数,这个字符(重复)可以被保留,如果个数为奇数的字符的个数>=2,则只有一个可以完全保留,其余的字符数量都要-1
 */
class Solution {
	
	public static void main(String[] args) {
		String s = "abccccdd";
		int len = longestPalindrome(s);
		System.out.println(len);
	}
    public static int longestPalindrome(String s) {
    	int[] ans = new int[128];
    	char[] chars = s.toCharArray();
    	//统计每个字符出现的次数
    	for (char c : chars) {
			ans[c]++;
		}
    	int len = ans.length;
    	int count = 0;
    	//统计奇数字符的个数
    	for (int i = 0; i < len; i++) {
			if(ans[i] % 2 != 0){
				count++;
			}
		}
    	
		return count = count >= 2 ? s.length()-count+1 : s.length();
    	
    }
}
