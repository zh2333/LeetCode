package com.leetcode.p43;

import org.junit.Test;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * @author 张恒
 *
 */

public class Solution {
	@Test
	public void test(){
		String s1 = "21";
		String s2 = "3";
		System.out.println(multiply(s1,s2));
	}
    public static String multiply(String num1, String num2) {
    	if("0".equals(num1) || "0".equals(num2)) return "0";
    	int len1 = num1.length();
    	int len2 = num2.length();
    	int len = len1+len2;
    	int[] ans = new int[len];
    	char[] numChar1 = num1.toCharArray();
    	char[] numChar2 = num2.toCharArray();
    	//将两个数组的每一位相乘然后相加并存入数组
    	for (int i = len1 -1; i >= 0 ; --i) {
			int int1 = numChar1[i] - '0';
			for(int j = len2 - 1;j>=0;--j){
				int int2 = numChar2[j] - '0';
				ans[i+j+1] += int1*int2;
			}
		}
    	
    	//大于10进位,将每一位格式化为0到9之间的数字,从后向前遍历
    	for(int i = len -1;i>=0;--i){
    		 if (ans[i] > 9) {
                 ans[i - 1] += ans[i] / 10;   //大于10了就要进位
                 ans[i] %= 10;
             }
    	}
    	
    	int index=0;//过滤掉数组中没有数字填充的位置
    	while(ans[index] == 0) index++;
    	
    	//找到第一个有效数字,将其重新转换成字符
    	StringBuilder sb = new StringBuilder();
    	while(index <= len-1){
    		sb.append((char)(ans[index] + '0'));
    		++index;
    	}
		return sb.toString();
    }
}