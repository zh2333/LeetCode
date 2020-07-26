package com.leetcode.p25;

import org.junit.Test;

import com.leetcode.datastructure.ListNode;

public class Solution {
	@Test
	public void test(){
		ListNode head = ListNode.generateList(5);
		head = reverseKGroup(head, 2);
		printList(head);
	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode currNode = head;
        ListNode p = null;
        
        int i;
        int flag = 0;
        while(currNode != null) {
        	ListNode lastNode = currNode;
        	ListNode tmp = null;
        	i = k;
        	while(i > 1 && lastNode != null) {
        		lastNode = lastNode.next;
        		i--;
        	}
        	if(lastNode.next != null) {
        		tmp = lastNode.next;
        	}
        	//记录第一次翻转的头结点
        	if(flag == 0) {
        		flag = 1;
        		reverseSubList(currNode, lastNode);
        		head = lastNode;
        		p = currNode;
        		printList(head);
        	} else {
        		reverseSubList(currNode, lastNode);
        		p.next = lastNode;
        		p=p.next;
        		printList(head);
        	}
        	if(lastNode == null){
        		//直接返回第一次找到的头结点
        		return head;
        	}
        	currNode = tmp;;
        }
        return head;
    }
    
    private void reverseSubList(ListNode head, ListNode lastNode) {
    	ListNode lastNodeNext = lastNode.next;
    	ListNode pre = null;
    	ListNode curr = head;
    	ListNode tmp = null;
    	while(curr != lastNodeNext) {
    		tmp = curr.next;
    		curr.next = pre;
    		pre = curr;
    		curr = tmp;
    	}
    	head.next = lastNodeNext;
    }
    private void printList(ListNode head){
    	ListNode p = head;
		while(p != null) {
			if(p.next != null) {
				System.out.print(p.val + "->");
			}else {
				System.out.println(p.val);
			}
			p = p.next;
		}
    }
}