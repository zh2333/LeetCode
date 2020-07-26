package com.leetcode.p151;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
	push(x) -- 将元素 x 推入栈中。
	pop() -- 删除栈顶的元素。
	top() -- 获取栈顶元素。
	getMin() -- 检索栈中的最小元素。
	示例:
	
	MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	minStack.getMin();   --> 返回 -3.
	minStack.pop();
	minStack.top();      --> 返回 0.
	minStack.getMin();   --> 返回 -2.

 * @author 张恒
 *	解决:
 *	使用两个 栈,一个用于正常的存放数据,另一个用于存放最小元素
 */
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
