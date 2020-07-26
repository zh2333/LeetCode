package com.leetcode.p19;

import com.leetcode.datastructure.ListNode;

/**
 * ɾ������ĵ�����n���ڵ�
 * ʹ���������Ϊn��ָ��,������ָ��ͬʱ����ƶ�,������ָ�뵽��β��ʱ
 * ǰ��һ��ָ�����һ��Ԫ��������Ҫɾ����Ԫ��
 * @author �ź�
 *
 */
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode pre = new ListNode(0);//��һ��Ҳ�ܹؼ�,�����˶�����ж�
		pre.next = head;
		ListNode start = pre;
		ListNode end = pre;
		
		//��һ��ָ�뿪ʼ����ƶ�
		while(n != 0){
			end = end.next;
			n--;
		}
		
		while(end.next != null){
			start = start.next;
			end = end.next;
		}
		start.next = start.next.next;
		return pre.next;
    }
	
}
