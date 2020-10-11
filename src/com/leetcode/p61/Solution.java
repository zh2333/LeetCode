package com.leetcode.p61;

import com.leetcode.datastructure.ListNode;
import com.leetcode.utils.MyList;

public class Solution {
	public static void main(String[] args) {
		ListNode head = MyList.generateList(10);
		MyList.printList(head);
		ListNode tmp = rotateRight(head, 3);
		MyList.printList(tmp);
		
	}
	public static ListNode rotateRight(ListNode head, int k) {
		if(head == null) return null;
		if(k == 0) return head;
		int len = 0;
		ListNode tmp = head;
		while( tmp.next != null) {
			len++;
			tmp = tmp.next;
		}
		len++;
		
		int distance = k % len;
		if(distance == 0) return head;
		
		ListNode gap = head;
		int steps = 1;
		while(steps < len - distance) {
			gap = gap.next;
			steps++;
		}
		
		ListNode gapNext = gap.next;
		gap.next = null;
		tmp.next = head;
		
		return gapNext;
		
    }
}
