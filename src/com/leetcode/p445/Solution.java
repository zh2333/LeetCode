package com.leetcode.p445;

import java.util.Stack;

import com.leetcode.datastructure.ListNode;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 

进阶：

如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

 

示例：

输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7
 * @author 张恒
 *
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	//判空处理
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
    	//1.用两个栈存放两个链表的节点
    	Stack<ListNode> stack1 = new Stack<>();
    	Stack<ListNode> stack2 = new Stack<>();
    	ListNode p1 = l1;
    	ListNode p2 = l2;
    	while(p1 != null){
    		stack1.push(p1);
    		p1 = p1.next;
    	}
    	while(p2 != null){
    		stack2.push(p2);
    		p2 = p2.next;
    	}
    	
    	//2.建一个stack存放加法结果
    	Stack<ListNode> stack3 = new Stack<ListNode>();
    	int barry = 0;
    	while(!stack1.isEmpty() && !stack2.isEmpty()){
    		int currNumval = stack1.pop().val+stack2.pop().val + barry;
    		ListNode currNum = new ListNode(currNumval % 10);
    		barry = currNumval / 10;
    		stack3.push(currNum);
    	}
    	//3.将两个链表中的一个节点的剩余节点存放到栈中
    	while(!stack1.isEmpty()){
    		int currNumval = stack1.pop().val + barry;
    		ListNode currNum = new ListNode(currNumval % 10);
    		barry = currNumval / 10;
    		stack3.push(currNum);

    	}
    	while(!stack2.isEmpty()){
    		int currNumval = stack2.pop().val + barry;
    		ListNode currNum = new ListNode(currNumval % 10);
    		barry = currNumval / 10;
    		stack3.push(currNum);
    	}
    	//4.将和栈中的元素重新建成一个链表
    	ListNode l3 = new ListNode(0);
    	ListNode p =l3;
    	while(!stack3.isEmpty()){
    		p.next = stack3.pop();
    		p = p.next;
    	}
    	if(barry > 0){
    		ListNode first = new ListNode(barry);
    		first.next = l3.next;
    		l3.next = first;
    	}
    	return l3.next;
    }
}