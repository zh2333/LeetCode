package com.offer.√Ê ‘Ã‚66;

class Solution {
    public int[] constructArr(int[] a) {
    	int len = a.length;
    	
    	int i = 1;
    	int[] left = new int[len];
    	left[0] = 1;
    	while(i < len){
    		left[i] =left[i-1] * a[i-1];
    		i++;
    	}
    	
    	int j = len-2;
    	int[] right = new int[len];
    	right[len-1] = 1;
    	while(j >= 0){
    		right[j] = right[j-1]*a[j-1];
    		j--;
    	}
    	for (int k = 0; k < len; k++) {
			a[i] = left[i]*right[i];
		}
		return a;
    }
}