package com.leetcode.p155;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
	private Stack<Integer> data;
	private Stack<Integer> min;
    /** initialize your data structure here. 构造方法*/
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
    	data.add(x);
    	if(min.isEmpty() || min.peek() >= x){
    		min.add(x);
    	}else{
    		//如果没有更小的元素就将当前辅助栈的栈顶元素复制一份,为了保持主栈和辅助栈的同步
    		min.add(min.peek());
    	}
    	
    }
    
    public void pop() {
    	if (!data.isEmpty()) {
			data.pop();
			min.pop();
		}
    }
    
    public int top() {
    	if (!data.isEmpty()) {
    		return data.peek();
		}
		 throw new RuntimeException("栈为空,操作非法");
    }
    
    public int getMin() {
		if (!min.isEmpty()) {
			return min.peek();
		}
		throw new RuntimeException("栈为空,操作非法");
    }
}