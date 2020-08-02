package com.leetcode.utils;

import com.leetcode.datastructure.ListNode;

public class List {
	/**
	 * 生成指定长度的链表
	 * @param count
	 * @return
	 */
	public static ListNode generateList(int count) {
		if(count == 0) {
			System.out.println("链表长度不能为0");
			return null;
		}
		ListNode head = new ListNode(1);
		ListNode currNode = head;
		for(int i = 2; i <= count ; i++) {
			ListNode tmp = new ListNode((int)(Math.random() * 10));
			currNode.next = tmp;
			currNode = tmp;
		}
		return head;
	}
	
	/**
	 * 打印链表
	 * @param head
	 */
	public static void printList(ListNode head) {
		if(head == null) {
			System.out.println("链表头不能为空");
		}
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
	
	/**
	 * 反转子链表
	 * @param startNode
	 * @param endNode
	 * @return
	 */
	public ListNode reverse(ListNode startNode, ListNode endNode) {
		if(endNode == null || startNode == null) {
			System.out.println("输入节点不能为空");
			return null;
		}
    	ListNode pre = null;
        ListNode curr = startNode;
        ListNode tmp = null;
        while(curr != endNode.next){
            tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return endNode;
    }
}
