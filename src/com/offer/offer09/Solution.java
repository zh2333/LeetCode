package com.offer.offer09;

import java.util.Stack;

class CQueue {
	Stack<Integer> s1;
	Stack<Integer> s2;
    public CQueue() {
    	this.s1 =  new Stack<>();
    	this.s2 =  new Stack<>();
    }
    
    public void appendTail(int value) {
    	while(!s1.isEmpty()){
    		s2.push(s1.pop());
    	}
    	Stack<Integer> tmp;
    	tmp = s1;
    	s1 = s2;
    	s2 = tmp;
    	s1.push(value);
    }
    
    public int deleteHead() {
    	while(!s1.isEmpty()){
    		s2.push(s1.pop());
    	}
    	Stack<Integer> tmp;
    	tmp = s1;
    	s1 = s2;
    	s2 = tmp;
    	if(!s1.isEmpty()){
    		return s1.pop();
    	}else{
    		throw new RuntimeException("������");
    	}
    }
}

