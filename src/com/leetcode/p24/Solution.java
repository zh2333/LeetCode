package com.leetcode.p24;

import com.leetcode.datastructure.ListNode;

/**
 * �����������������ڵĽڵ�
 * ���:���һ������Ľڵ�ͳһ����
 * @author �ź�
 *
 */
public class Solution {
	public ListNode swapPairs(ListNode head) {
		ListNode extra = new ListNode(0);
		ListNode a,b,c;
		extra.next = head;
		c = extra;
		while(c.next != null && c.next.next != null){
			 a = c.next;
			 b = c.next.next;
			 //��ʼ����
			 c.next = b;
			 a.next = b.next;
			 b.next = a;
			 c = c.next.next;
		}
		return extra.next;
    }
}

