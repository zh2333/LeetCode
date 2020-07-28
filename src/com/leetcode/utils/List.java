package com.leetcode.utils;

import com.leetcode.datastructure.ListNode;

public class List {
	public static ListNode generateList(int count) {
		ListNode head = new ListNode(1);
		ListNode currNode = head;
		for(int i = 2; i <= count ; i++) {
			ListNode tmp = new ListNode((int)(Math.random() * 10));
			currNode.next = tmp;
			currNode = tmp;
		}
		return head;
	}
	
	public static void printList(ListNode head) {
		while(head != null) {
			if(head.next != null) {
				System.out.print(head.val + "->");
			} else {
				System.out.print(head.val);
			}
			head = head.next;
		}
		System.out.println("");
	}
}
