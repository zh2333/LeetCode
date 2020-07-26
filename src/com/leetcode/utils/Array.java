package com.leetcode.utils;

import org.junit.Test;

public class Array {
	public static void printArray(int[] array) {
		for(int num : array) {
			System.out.print(num + " ");
		}
		
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
	
	@Test
	public void test() {
		int[][] test = {{1,3},{2,6},{8,10},{15,18}};
		printTwoDimArray(test);
	}
	
}
