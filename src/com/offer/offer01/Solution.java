package com.offer.offer01;

import com.leetcode.utils.MyArray;
import org.junit.Test;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {

    @Test
    public void test() {
        int[][] arr = MyArray.generateTwoDimArray(5, 4);
        MyArray.printTwoDimArray(arr);
        System.out.println(findNumberIn2DArray(arr, 9));
    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int rows = matrix.length;
        int columns = matrix[0].length;

        int i = rows - 1;
        int j = 0;
        while (i >= 0 && j <= columns - 1) {
            if (target > matrix[i][j]) {
                j++;
            } else if (target < matrix[i][j]) {
                i--;
            } else if (target == matrix[i][j]){
                return true;
            }
        }
        return false;
    }
}
