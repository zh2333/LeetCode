package com.leetcode.p203;

import org.junit.Test;

import com.leetcode.datastructure.ListNode;
import com.leetcode.utils.MyList;

/**
 * 
	ɾ�������е��ڸ���ֵ val �����нڵ㡣
	ʾ��:
	����: 1->2->6->3->4->5->6, val = 6
	���: 1->2->3->4->5
 * @author �ź�
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
		System.out.println("�������: " + wrong);
	}
	
	public void test(int len, int val) {
		System.out.println("ɾ��: " + val);
		ListNode head = MyList.generateList(len);
		MyList.printList(head);
		head = removeElements(head, val);
		MyList.printList(head);
	}
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return head;
		//��������ͷ��ֵΪval�����
			while(head != null && head.val == val ) {
				head = head.next;
			}
			if(head == null) {
				return null;
			}
		ListNode pre = head;
		ListNode currNode = pre.next;//����ѭ��ʱ, head��ֵ������val, ֱ�Ӵ���һ���ڵ㿪ʼ�ж�
		while(currNode != null && currNode.next != null) {
			if(currNode.val == val) {
				pre.next = currNode.next;
				currNode = currNode.next;
			} else {
				pre = pre.next;
				currNode = pre.next;
			}
		}
		//�������һ���ڵ�����
		if(currNode != null && currNode.val == val ) {
			pre.next = null;
		}
		return head;
    }
}
