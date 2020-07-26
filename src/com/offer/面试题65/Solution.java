package com.offer.面试题65;

class Solution {
	/**
	 * 加法等于,a^b + (a&b)<<1
	 * @param a
	 * @param b
	 * @return
	 */
    public int add(int a, int b) {
    	while(a != 0){//a不为0表示有进位
    		int noCarryPlus = a ^ b;
    		a = (a&b) << 1;
    		b = noCarryPlus;
    	}
    	return b;
    }
}
