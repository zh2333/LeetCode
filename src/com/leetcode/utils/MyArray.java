package com.leetcode.utils;

/**
 * 面向数组的辅助测试类
 * @author zh
 *
 */
public class MyArray {
	
	/**
	 * 生成一个二维数组
	 * @param m
	 * @param n
	 * @return
	 */
	public static int[][] generateTwoDimArray(int m, int n) {
		int[][] array = new int[m][n];
		for(int i = 0; i < m;i++) {
			for(int j = 0;j < n;j++) {
				array[i][j] = (int)(Math.random() * 10);
			}
		}
		return array;
	}
	/**
	 * 生成一个一维数组
	 * @param count
	 * @return
	 */
	public static int[] generateArray(int count) {
		int[] array = new int[count];
		for(int i = 0; i < count;i++) {
			array[i] = (int)(Math.random() * 10);
		}
		return array;
	}
	/**
	 * 打印一维数组
	 * @param array
	 */
	public static void printArray(int[] array) {
		System.out.print("[");
		int len = array.length;
		for (int i = 0; i < array.length; i++) {
			if(i == len - 1) {
				System.out.print(array[i]);
			} else {
				System.out.print(array[i] + ",");
			}
		}
		System.out.println("]");
	}
	
	/**
	 * 打印二维数组
	 * @param array
	 */
	public static void printTwoDimArray(int[][] array) {
		System.out.println("{");
		for(int i = 0; i < array.length; i++) {
			System.out.print(" {");
			for(int j = 0; j < array[0].length;j++) {
				if(j < array[0].length - 1){
					System.out.print(array[i][j] + ",");
				} else {
					System.out.print(array[i][j]);
				}
			}
			System.out.println("},");
		}
		System.out.println("}");
	}
	
	/**
	 * 交换数组中的两个元素
	 * @param Array
	 * @param index1
	 * @param index2
	 */
	public static void swap(int[] Array, int index1, int index2) {
		int tmp = Array[index1];
		Array[index1] = Array[index2];
		Array[index2] = tmp;
	}
	
}
