package com.leetcode.p160;

import com.leetcode.datastructure.ListNode;

/**
 * 找到两个单链表相交的起始节点。
 * @author 张恒
 *
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	ListNode pA = headA;
    	ListNode pB = headB;
    	
    	if(pA == null || pB ==null) return null;
    	
    	while(pA != pB){
    		pA = pA == null ? headB : pA.next;
    		pB = pB == null ? headA : pB.next;
    	}
		return pA;
        
    }
}