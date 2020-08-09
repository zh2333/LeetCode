package com.offer.Bigadd;

import java.util.Scanner;

/**
 * �������:����ת�����ַ���,Ȼ�����ַ���ģ��ӷ���λ
 * @author �ź�
 *
 */
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num1 = sc.nextLine();
		String num2 = sc.nextLine();
		System.out.println(addStrings(num1, num2));
	}
    public static String addStrings(String num1, String num2) {
    	int len1 = num1.length();
    	int len2 = num2.length();
    	int i = len1 - 1;
    	int j = len2 - 1;
    	int barry = 0;
    	StringBuilder sb = new StringBuilder();
    	while(i >= 0 || j >= 0){
    		int tmp1 = i >= 0 ? num1.charAt(i) - '0': 0;
    		int tmp2 = j >= 0 ? num2.charAt(j) - '0': 0;
    		int tmp = tmp1 + tmp2 + barry;
    		barry = tmp / 10;
    		sb.append(tmp % 10);
    		i--;
    		j--;
    	}
    	return sb.reverse().toString();
    }
}