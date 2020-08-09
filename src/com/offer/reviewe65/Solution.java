package com.offer.reviewe65;

class Solution {
	/**
	 * �ӷ�����,a^b + (a&b)<<1
	 * @param a
	 * @param b
	 * @return
	 */
    public int add(int a, int b) {
    	while(a != 0){//a��Ϊ0��ʾ�н�λ
    		int noCarryPlus = a ^ b;
    		a = (a&b) << 1;
    		b = noCarryPlus;
    	}
    	return b;
    }
}
