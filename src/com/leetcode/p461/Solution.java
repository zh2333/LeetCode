package com.leetcode.p461;

/**
 * ��������֮��ĺ�������ָ�������������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��
	
	������������ x �� y����������֮��ĺ������롣
	
	ע�⣺
	0 �� x, y < 231.
	
	ʾ��:
	
	����: x = 1, y = 4
	
	���: 2
	
	����:
	1   (0 0 0 1)
	4   (0 1 0 0)
	       ��   ��
	
	����ļ�ͷָ���˶�Ӧ������λ��ͬ��λ�á�
 * @author �ź�
 *
 */
class Solution {
    public int hammingDistance(int x, int y) {
    	String s = Integer.toBinaryString(x^y);
		
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if('1' == s.charAt(i)){
				count +=1;
			}
		}
		return count;
    }
}