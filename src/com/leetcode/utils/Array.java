package com.leetcode.utils;

import org.junit.Test;

public class Array {
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
		System.out.print("}");
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
	
}
