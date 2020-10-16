package com.offer.offer16;

import com.leetcode.datastructure.ListNode;

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
    	ListNode pre = head;
    	ListNode valNode = head.next;
    	
    	while(valNode != null && valNode.next!=null){
    		if(valNode.val == val){
    			pre.next = valNode.next;
    			valNode.next = null;
    			valNode = pre.next;
    		}else{
    			valNode = valNode.next;
    			pre = pre.next;
    		}
    	}
    	if(valNode.val == val){
    		pre.next = null;
    	}
    	return head;
    }
}