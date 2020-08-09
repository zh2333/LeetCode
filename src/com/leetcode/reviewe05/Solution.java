package com.leetcode.reviewe05;

class Solution {
	public static void main(String[] args) {
		String s = "we are happy";
		System.out.println(replaceSpace(s));
	}
    public static String replaceSpace(String s) {
    	return s.replaceAll(" ", "%20");
    }
}