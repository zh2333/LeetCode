package com.leetcode.p125;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 
	����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
	˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���
	ʾ�� 1:
	����: "A man, a plan, a canal: Panama"
	���: true
	ʾ�� 2:
	����: "race a car"
	���: false
 * @author �ź�
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
