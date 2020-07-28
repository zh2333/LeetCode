package com.leetcode.p392;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

	你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
	
	字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
	
	示例 1:
	s = "abc", t = "ahbgdc"
	
	返回 true.
	
	示例 2:
	s = "axc", t = "ahbgdc"
	
	返回 false.
 * @author 张恒
 *
 */
class Solution {
	
	public static void main(String[] args) {
		String s = "abc";
		String t = "abde";
		
		System.out.println(isSubsequence(s, t));
	}
    public static boolean isSubsequence(String s, String t) {
    	int lengths = s.length();
    	int lengtht = t.length();
    	if(lengths > lengtht) return false;
    	
    	
    	Stack<Character> stacks = new Stack<>();
    	Stack<Character> stackt = new Stack<>();
    	
    	for(int i = 0; i < lengths;i++) {
    		stacks.add(s.charAt(i));
    	}
    	for(int i = 0; i < lengtht;i++) {
    		stackt.add(t.charAt(i));
    	}
    	
    	int m = 0;
    	int n = 0;
    	while(!stacks.isEmpty()) {
    		if(stacks.peek() == stackt.peek()) {
    			stacks.pop();
    			stackt.pop();
    		} else {
    			stackt.pop();
    		}
    		if(!stacks.isEmpty() && stackt.isEmpty()) {
    			return false;
    		}
    	}
    	return true;
    }
}
