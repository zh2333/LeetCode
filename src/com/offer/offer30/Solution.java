package com.offer.offer30;

import java.util.LinkedList;

class MinStack {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;
    public MinStack() {
    	this.stack = new LinkedList<Integer>();
    	this.minStack = new  LinkedList<Integer>();
    }
    
    public void push(int x) {
    	stack.add(x);
    	if(minStack.isEmpty()){
    		minStack.add(x);
    	}else if(minStack.getLast() > x){
    		minStack.add(x);
    	}
    	
    }
    
    public void pop() {
    	if(!stack.isEmpty() && !minStack.isEmpty() && stack.getLast() == minStack.getLast()){
    		stack.removeLast();
    		minStack.removeLast();
    	}
    	
    }
    
    public int top() {
    	if(!stack.isEmpty()){
    		return stack.getLast();
    	}else{
    		return -1;
    	}
    }
    
    public int min() {
    	return minStack.getLast();
    }
}
