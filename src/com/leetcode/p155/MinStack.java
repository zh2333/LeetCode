package com.leetcode.p155;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
	private Stack<Integer> data;
	private Stack<Integer> min;
    /** initialize your data structure here. ���췽��*/
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
    	data.add(x);
    	if(min.isEmpty() || min.peek() >= x){
    		min.add(x);
    	}else{
    		//���û�и�С��Ԫ�ؾͽ���ǰ����ջ��ջ��Ԫ�ظ���һ��,Ϊ�˱�����ջ�͸���ջ��ͬ��
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
		 throw new RuntimeException("ջΪ��,�����Ƿ�");
    }
    
    public int getMin() {
		if (!min.isEmpty()) {
			return min.peek();
		}
		throw new RuntimeException("ջΪ��,�����Ƿ�");
    }
}