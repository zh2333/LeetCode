package com.offer.offer09;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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

