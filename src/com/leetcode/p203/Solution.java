package com.leetcode.p203;

import org.junit.Test;

import com.leetcode.datastructure.ListNode;
import com.leetcode.utils.List;

/**
 * 
	删除链表中等于给定值 val 的所有节点。
	示例:
	输入: 1->2->6->3->4->5->6, val = 6
	输出: 1->2->3->4->5
 * @author 张恒
 *
 */
public class Solution {
	@Test
	public void dupTest() {
		int wrong = 0;
		for(int i = 0; i < 100000;i++) {
			int len = (int)(Math.random() * 20);
			int val = (int)(Math.random() * 10);
			try {
				test(len , val);
			} catch(Exception e) {
				wrong++;
			}
		}
		System.out.println("出错次数: " + wrong);
	}
	
	public void test(int len, int val) {
		System.out.println("删除: " + val);
		ListNode head = List.generateList(len);
		List.printList(head);
		head = removeElements(head, val);
		List.printList(head);
	}
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return head;
		//考虑链表头部值为val的情况
			while(head != null && head.val == val ) {
				head = head.next;
			}
			if(head == null) {
				return null;
			}
		ListNode pre = head;
		ListNode currNode = pre.next;//跳出循环时, head的值不等于val, 直接从下一个节点开始判断
		while(currNode != null && currNode.next != null) {
			if(currNode.val == val) {
				pre.next = currNode.next;
				currNode = currNode.next;
			} else {
				pre = pre.next;
				currNode = pre.next;
			}
		}
		//考虑最后一个节点的情况
		if(currNode != null && currNode.val == val ) {
			pre.next = null;
		}
		return head;
    }
}
