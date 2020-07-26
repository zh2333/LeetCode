package com.leetcode.p142;

import com.leetcode.datastructure.ListNode;

/**
 * �ҵ������������ڵ�
 * @author �ź�
 *
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
    	if(head == null || head.next == null) return null;
    	
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	while(slow != fast){
    		if(fast == null || fast.next==null){
    			return null;
    		}
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	fast = head;
    	while(fast != slow){
    		fast = fast.next;
    		slow = slow.next;
    	}
    	return fast;
    }
}
