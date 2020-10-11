package com.leetcode.p73;

import java.util.HashSet;
import org.junit.Test;
import com.leetcode.utils.MyArray;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

	示例 1:
	
	输入: 
	[
	  [1,1,1],
	  [1,0,1],
	  [1,1,1]
	]
	输出: 
	[
	  [1,0,1],
	  [0,0,0],
	  [1,0,1]
	]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/set-matrix-zeroes
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张恒
 *
 */
public class Solution {
	@Test
	public void test() {
		int[][] array = MyArray.generateTwoDimArray(5, 4);
		MyArray.printTwoDimArray(array);
		setZeroes(array);
		MyArray.printTwoDimArray(array);
	}
    public void setZeroes(int[][] matrix) {
    	HashSet<Integer> setH = new HashSet<>();
    	HashSet<Integer> setL = new HashSet<>();
    	for(int i = 0;i < matrix.length; i++) {
    		for(int j = 0; j < matrix[0].length;j++) {
    			if(matrix[i][j] == 0) {
    				setH.add(i);
    				setL.add(j);
    			}
    		}
    	}
    	for(int j = 0 ; j < matrix[0].length;j++) {
    		for(Integer i : setH) {
        		matrix[i][j] = 0;
        	}
    	}
    	
    	for(int j = 0 ; j < matrix.length;j++) {
    		for(Integer i : setL) {
        		matrix[j][i] = 0;
        	}
    	}    	
    }
}
