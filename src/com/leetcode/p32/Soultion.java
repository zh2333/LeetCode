package com.leetcode.p32;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 解决:
 * 遇到(就将其在字符串中的位置入栈,否则是遇到了),此时将栈顶元素出战,并将两者作差,每次比较更新最大值
 * @author 张恒
 *
 */
class Solution {
    public int longestValidParentheses(String s) {
    	int maxlen = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(-1);
    	for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '('){
				stack.push(i);
			}else{
				stack.pop();
				if(stack.isEmpty()){
					stack.push(i);
				}else{
					maxlen = Math.max(maxlen, i - stack.peek());
				}
				
			}
		}
    	return maxlen;
    }
}