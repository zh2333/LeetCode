package com.leetcode.p136;

/**
 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
 * @author �ź�
 *���:�������.
 *
 */
public class Solution {
	public static void main(String[] args) {
		int[] test = {4,1,2,1,2};
		System.out.println(singleNumber(test));
	}
    public static int singleNumber(int[] nums) {
    	int ans = 0;
    	for (int num : nums) {
			ans ^=num;
		}
		return ans;
    }
}