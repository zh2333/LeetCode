package com.leetcode.p62;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
	机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
	问总共有多少条不同的路径？
 * @author 张恒
 *	解决:动态规划
 *	到达右下角的点的路径数=上面到达上面一个点的路径数+到达左边一个点的路径数
 */
class Solution {
	
    public int uniquePaths(int m, int n) {
    	int[][] dp = new int[m][n];
    	
    	//初始条件,最左上角的点
    	dp[0][0]=0;
    	
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
				//如果该点是在最上面或者最左边,那么到达该点只有一种方法
    			if(i == 0||j == 0){
    				dp[i][j] = 1;
    			}else{
    				dp[i][j] = dp[i-1][j]+dp[i][j-1];
    			}
			}
		}
    	return dp[m-1][n-1];
    }
}
