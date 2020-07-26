package com.leetcode.p48;

/**
 * 旋转图像:
 * 给定一个 n × n 的二维矩阵表示一个图像。
	将图像顺时针旋转 90 度。
	说明：
	你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
	示例 1:
	给定 matrix = 
	[
	  [1,2,3],
	  [4,5,6],
	  [7,8,9]
	],
	
	原地旋转输入矩阵，使其变为:
	[
	  [7,4,1],
	  [8,5,2],
	  [9,6,3]
	]
	示例 2:
	
	给定 matrix =
	[
	  [ 5, 1, 9,11],
	  [ 2, 4, 8,10],
	  [13, 3, 6, 7],
	  [15,14,12,16]
	], 
	
	原地旋转输入矩阵，使其变为:
	[
	  [15,13, 2, 5],
	  [14, 3, 4, 1],
	  [12, 6, 8, 9],
	  [16, 7,10,11]
	]

 * @author 张恒
 *	解决:
 *先转置再交换每一行的第i和len-i-1个元素
 *	1 2 3         1 4 7		  7 4 1
 *	4 5 6  ---->  2 5 8 ----> 8 5 2
 *	7 8 9         3 6 9		  9 6 3
 */
class Solution {
    public void rotate(int[][] matrix) {
    	int len = matrix.length;
    	
    	//转置矩阵
    	for (int i = 0; i < len; i++) {
			for (int j = i; j <len; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
    	
    	//翻转每行元素
    	for (int i = 0; i < len; i++) {
			for (int j = 0; j < len/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][len-j-1];
				matrix[i][len-j-1] = temp;
			}
		}
    }
}
