package com.newcoder.NC140;

import com.leetcode.utils.MyArray;
import org.junit.Test;

import java.util.Arrays;

/**
 *题目描述
 * 给定一个数组，请你编写一个函数，返回该数组排序后的形式。
 * 示例1
 * 输入
 * [5,2,3,1,4]
 * 返回值
 * [1,2,3,4,5]
 * 示例2
 * 输入
 * [5,1,6,2,5]
 * 返回值
 * [1,2,5,5,6]
 */
public class Solution {
    @Test
    public void test() {
        int[] arr = MyArray.generateArray(7);
        MyArray.printArray(arr);
        arr = MySort(arr);
        MyArray.printArray(arr);
    }
    public int[] MySort (int[] arr) {
        int len = arr.length;
        if (len == 0 || len == 1) {
            return arr;
        }
        quickSort(arr, 0, len - 1);
        return arr;
    }
    public void quickSort(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        if (i < j) {
            int middle = arr[high];
            while (i < j) {
                //从左向右找到一个大于middle的数放在middle的右边
                while (i < j && arr[i] < middle) {
                    ++i;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    --j;
                }
                //从右向左找到一个数小于middle放在middle的左边
                while (i < j && middle < arr[j]) {
                    --j;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    ++i;
                }
            }
            arr[i] = middle;
            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
        }
    }
}
