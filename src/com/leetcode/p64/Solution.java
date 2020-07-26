package com.leetcode.p64;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
	说明：每次只能向下或者向右移动一步。
	示例:
	输入:
	[
	  [1,3,1],
	  [1,5,1],
	  [4,2,1]
	]
	输出: 7
	解释: 因为路径 1→3→1→1→1 的总和最小。
 * @author 张恒
 *	动态规划:
 */
class Solution {
	public static void main(String[] args) {
			int[][] x ={{1,2,5},{3,2,1}};
			System.out.println(minPathSum(x));
		
	}
    public static int minPathSum(int[][] grid) {
    	int h = grid.length;//行
    	int w = grid[0].length;//列
    	if(h==0 && w==0) return 0;
    	int[][] dp = new int[h][w];
    	
    	//初始条件
    	dp[0][0] = grid[0][0];
    	for (int i = 0; i < h; i++) {
    		for (int j = 0; j < w; j++) {
    			int temp =grid[i][j];
				if(i==0 && j!=0){
					dp[i][j]=dp[i][j-1]+temp;
				}else if(j==0 && i!=0) {
					dp[i][j]=dp[i-1][j]+temp;
				}else if(i!=0&&j!=0){
					dp[i][j] = dp[i][j-1] < dp[i-1][j] ? dp[i][j-1]+temp : dp[i-1][j]+temp;
				}	
			}
			
		}
		return dp[h-1][w-1];
    }
}