package com.leetcode.test;

class Solution {
	public static void main(String[] args) {
		System.out.println(numWays(2));
	}
    public static int numWays(int n) {
        if(n == 0 || n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i = 2;i<n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[dp.length-1];
    }
}