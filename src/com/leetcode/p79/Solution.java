package com.leetcode.p79;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
	单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
	示例:
	board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
	给定 word = "ABCCED", 返回 true.
	给定 word = "SEE", 返回 true.
	给定 word = "ABCB", 返回 false.
 * @author 张恒
 *	解决:
 * 	回溯
 * 	0-----------x------------
 * 	|
 * 	|
 * 	|
 * 	|		  (x,y-1)
 * 	y (x-1,y) ( x, y)   (x+1,y)
 * 	|		  (x,y+1)
 * 	|
 * 	|
 * 	|
 * 	|
 * 	定义一个坐标系.用一个方向数组控制方向的移动
 * 	int[][] directions = {{0,-1},{1,0},{0,1}{-1,0}}
 * 	定义一个marked数组用于标记棋盘上的某个字母是否已经遍历
 */
class Solution {
	private static int m;
	private static int n;
	private static int[][] directions = {{0,-1},{1,0},{0,1},{-1,0}};//初始化方向数组
	private static String word;
	private static boolean[][] marked;//标记数组,该位为true表示已经被走过
	private static char[][] board;
	private static int len;
    public boolean exist(char[][] board, String word) {
    	Solution.board = board;
    	Solution.word = word;
    	Solution.m = board.length;
    	if(m == 0) return false;
    	Solution.n= board[0].length;
    	Solution.marked = new boolean[m][n];
    	Solution.len = word.length();
    	
    	//利用二维数组遍历棋盘
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if(dfs(i,j,0)){
    				return true;
    			}
			}
		}
    	return false;
    }
    
    //深度优先遍历
    public boolean dfs(int m,int n,int start){
    	//判断是否已经遍历到word的最后一个字母,如果能找到返回true
    	if(start == len-1){
    		return board[m][n] == word.charAt(start);
    	}
    	
    	//如果当前word中的字母在board中找到,就把board中的某一位置为true,并移动指针
    	if(board[m][n] == word.charAt(start)){
    		marked[m][n] = true;
    		//向四个方向尝试
    		for (int i = 0; i < 4; i++) {
				int nextX = m + directions[i][0];
				int nextY = n + directions[i][1];
				//如果县一个坐标没哟越界并且未被标记为true,就访问这个坐标
				if(inArea(nextX, nextY) && !marked[nextX][nextY]){
					if(dfs(nextX, nextY, start+1)){
                        return true;
                    }
				}
				
			}
            
            marked[m][n] = false;
    	}
    	
		return false;
    	
    }
    
    //判断坐标是否越界,x大于0并且小于列宽,y大于等于0并小于行宽
    public static boolean inArea(int x, int y){
		return x >=0 && x<m && y>=0 && y<n;
	}
}