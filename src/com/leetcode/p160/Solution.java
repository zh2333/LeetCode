package com.leetcode.p160;

import com.leetcode.datastructure.ListNode;

/**
 * �ҵ������������ཻ����ʼ�ڵ㡣
 * @author �ź�
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