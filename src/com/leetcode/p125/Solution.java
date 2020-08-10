package com.leetcode.p125;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 
	给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
	说明：本题中，我们将空字符串定义为有效的回文串。
	示例 1:
	输入: "A man, a plan, a canal: Panama"
	输出: true
	示例 2:
	输入: "race a car"
	输出: false
 * @author 张恒
 *
 */
public class Solution {
	@Test
	public void test() {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}
	public boolean isPalindrome(String s) {
		int len = s.length();
		String news = s.toUpperCase();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			char c = news.charAt(i);
			if(isLetter(c)) {
				
			}
		}
		
		int newLen = sb.length();
		for (int i = 0; i < newLen / 2; i++) {
			if(sb.charAt(i) != sb.charAt(newLen- i - 1)){
				return false;
			}
		}
		return true;
    }
	
	public boolean isLetter(char c) {
		return (c >= 65 && c <= 90) || (c >=48 && c <= 57);
	}
	
}
