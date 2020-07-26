package com.leetcode.p1013;

/**
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
	形式上，如果可以找出索引 i+1 < j 且满足 
	(A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 * @author 张恒
 *	题目中给定的数组已经分区分好,只需要从前向后遍历即可
 *	如果达到了数组中总和的1/3,就把当前区的和置为0,count++
 */
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
    	if(A.length == 0) return false;
    	int sum = 0;
    	for (int i : A) {
			sum += i;
		}
    	
    	if(sum % 3 != 0){
    		return false;
    	}
    	
    	int currSum = 0;
    	int count = 0;
    	for (int i = 0; i < A.length; i++) {
			currSum += A[i];
			if(currSum == sum /3){
				currSum = 0;
				count++;
			}
		}
		return count == 3;
    }
}
