package com.leetcode.p32;

import java.util.Stack;

/**
 * ����һ��ֻ���� '(' �� ')' ���ַ������ҳ���İ�����Ч���ŵ��Ӵ��ĳ��ȡ�
 * ���:
 * ����(�ͽ������ַ����е�λ����ջ,������������),��ʱ��ջ��Ԫ�س�ս,������������,ÿ�αȽϸ������ֵ
 * @author �ź�
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