package com.leetcode.p121;

public class Solution {
	
	public static void main(String[] args) {
		int[] test = {7,6,4,3,1};
		System.out.println(maxProfit(test));
	}
    public static int maxProfit(int[] prices) {
    	int maxProfit=0;
    	int preProfit = 0;
    	for (int i = 0; i < prices.length; i++) {
			for (int j = i+1; j < prices.length; j++) {
				if(prices[j] > prices[i]){
					preProfit = prices[j] - prices[i];
					maxProfit = preProfit > maxProfit ? preProfit : maxProfit;
				}
			}
		}
		return maxProfit;

    }
}
