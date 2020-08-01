package com.leetcode.utils;

import org.junit.Test;

public class Array {
	public static int[][] generateTwoDimArray(int m, int n) {
		int[][] array = new int[m][n];
		for(int i = 0; i < m;i++) {
			for(int j = 0;j < n;j++) {
				array[i][j] = (int)(Math.random() * 10);
			}
		}
		return array;
	}
	public static int[] generateArray(int count) {
		int[] array = new int[count];
		for(int i = 0; i < count;i++) {
			array[i] = (int)(Math.random() * 10);
		}
		return array;
	}
	public static void printArray(int[] array) {
		System.out.print("{");
		int len = array.length;
		for (int i = 0; i < array.length; i++) {
			if(i == len - 1) {
				System.out.print(array[i]);
			} else {
				System.out.print(array[i] + ",");
			}
		}
		System.out.println("}");
	}
	
	public static void printTwoDimArray(int[][] array) {
		System.out.print("{");
		for(int i = 0; i < array.length; i++) {
			System.out.print("{");
			for(int j = 0; j < array[0].length;j++) {
				if(j < array[0].length - 1){
					System.out.print(array[i][j] + ",");
				} else {
					System.out.print(array[i][j]);
				}
			}
			System.out.print("}");
		}
		System.out.println("}");
	}
	
	public static void swap(int[] Array, int index1, int index2) {
		int tmp = Array[index1];
		Array[index1] = Array[index2];
		Array[index2] = tmp;
	}
	
}
