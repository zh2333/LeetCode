package com.leetcode.datastructure;

 // Definition for singly-linked list.
  public class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x) { val = x; next=null;} 
      public static ListNode generateList(int count) {
    	  ListNode head = new ListNode(-1);
    	  ListNode p = head;
    	  for (int i = 0; i < count; i++) {
			ListNode currNode = new ListNode(i);
			p.next = currNode;
			p = p.next;
		}
    	 return head.next; 
      }
  }
  
  

