package com.leetcode.p24;

import com.leetcode.datastructure.ListNode;

/**
 * 两两交换链表中相邻的节点
 * 解决:添加一个额外的节点统一操作
 * @author 张恒
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
			 //开始交换
			 c.next = b;
			 a.next = b.next;
			 b.next = a;
			 c = c.next.next;
		}
		return extra.next;
    }
}

