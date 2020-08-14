package com.leetcode.p86;

import org.junit.Test;

import com.leetcode.datastructure.ListNode;
import com.leetcode.utils.MyList;

/**
 * ����һ�������һ���ض�ֵ x����������зָ���ʹ������С�� x �Ľڵ㶼�ڴ��ڻ���� x �Ľڵ�֮ǰ��

	��Ӧ����������������ÿ���ڵ�ĳ�ʼ���λ�á�
	
	ʾ��:
	
	����: head = 1->4->3->2->5->2, x = 3
	���: 1->2->2->4->3->5
	
	��Դ�����ۣ�LeetCode��
	���ӣ�https://leetcode-cn.com/problems/partition-list
	����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author �ź�
 *
 */
public class Solution {
	@Test
	public void test() {
		ListNode head = MyList.generateList(10);
		MyList.printList(head);
		head = partition(head, 6);
		MyList.printList(head);
	}
	public ListNode partition(ListNode head, int x) {
		if(head == null) return null;
		if(head.next == null) return head;
		
		ListNode minHead = new ListNode(0);
		ListNode minMove = minHead;
		ListNode maxhead = new ListNode(0);
		ListNode maxMove = maxhead;
		ListNode move = head;
		//�����ڵ���x�Ľڵ��С��x�Ľڵ�ֱ��ŵ�����������
		while(move != null) {
			if(move.val < x) {
				minMove.next = new ListNode(move.val);
				minMove = minMove.next;
			} else {
				maxMove.next = new ListNode(move.val);
				maxMove = maxMove.next;
			}
			move = move.next;
		}
		minMove.next = maxhead.next;
		return minHead.next;
    }
}
