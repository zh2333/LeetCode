package com.leetcode.√Ê ‘Ã‚06;

import java.util.Stack;

import com.leetcode.datastructure.ListNode;

class Solution {
    public int[] reversePrint(ListNode head) {
    	
    	String s;
    	
    	ListNode node = head;
    	Stack<Integer> stack = new Stack<Integer>();
    	while(node != null){
    		stack.add(node.val);
    		node = node.next;
    	}
    	
    	int[] res = new int[stack.size()];
    	int i = 0;
    	while(!stack.isEmpty()){
    		res[i] = stack.pop();
    		i++;
    	}
    	
    	return res;
    }
}