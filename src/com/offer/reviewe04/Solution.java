package com.offer.reviewe04;

/**
 * 
��һ�� n * m �Ķ�ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
�����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������

ʾ��:

���о��� matrix ���£�

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
 * @author �ź�
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
    	//�����һ���ҵ�target���λ����һ��֮��,��С������Χ
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