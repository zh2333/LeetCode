package com.leetcode.utils;

import com.leetcode.datastructure.ListNode;

public class MyList {
	/**
	 * ����ָ�����ȵ�����
	 * @param count
	 * @return
	 */
	public static ListNode generateList(int count) {
		if(count == 0) {
			System.out.println("�����Ȳ���Ϊ0");
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
	 * ��ӡ����
	 * @param head
	 */
	public static void printList(ListNode head) {
		if(head == null) {
			System.out.println("����ͷ����Ϊ��");
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
	 * ��ת������
	 * @param startNode
	 * @param endNode
	 * @return
	 */
	public ListNode reverse(ListNode startNode, ListNode endNode) {
		if(endNode == null || startNode == null) {
			System.out.println("����ڵ㲻��Ϊ��");
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
