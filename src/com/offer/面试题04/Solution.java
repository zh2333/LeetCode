package com.offer.面试题04;

import org.junit.experimental.max.MaxCore;

/**
 * 
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
 * @author 张恒
 *
 */
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	if(target > matrix[m-1][n-1]){
    		return false;
    	}
    	int column = 0;
    	int row = 0;
    	//从最后一行找到target大概位于哪一列之后,缩小搜索范围
    	for (int k = 0; k < n; k++) {
			if(matrix[m - 1][k] < target ){
				continue;
			}else if(matrix[m - 1][k] ==  target ){
				return true;
			}else{
				column = k;
				break;
			}
		}
    	for (int k = 0; k < m; k++) {
			if(matrix[k][n - 1] < target ){
				continue;
			}else if(matrix[k][n-1] ==  target ){
				return true;
			}else{
				row = k;
				break;
			}
		}
    	for (int i = row; i < m; i++) {
    		for (int j = column; j < n; j++) {
				if(matrix[i][j] == target){
					return true;
				}
			}
		}
		return false;
    }
    
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int x = m;
    	int y = 0;
    	if(target > matrix[m-1][n-1]){
    		return false;
    	}
    	
    	while(x >= 0){
    		while(y < n && matrix[x][y] < target) y++;
    		if(y < n && matrix[x][y] == target){
    			return true;
    		}
    		x--;
    	}
		return false;
    }
}