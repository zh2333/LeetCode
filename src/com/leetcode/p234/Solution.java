package com.leetcode.p234;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.datastructure.ListNode;

/**
 * �ж�һ�������Ƿ��ǻ�������:
 * ���ж�һ�������Ƿ�Ϊ��������
	ʾ�� 1:
	
	����: 1->2
	���: false
	ʾ�� 2:
	
	����: 1->2->2->1
	���: true
 * @author �ź�
 *
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
    	if (head == null || head.next == null) {
    		return true;
		}
		ListNode n1 = head;
    	ListNode n2 = head;
    	while (n2.next != null && n2.next.next != null) {
    		n1 = n1.next;
    		n2 = n2.next.next;
		}
    	n2 = n1.next;
    	n1.next = null;
    	ListNode n3 = null;
    	while (n2 != null) {
    		n3 = n2.next;
    		n2.next = n1;
    		n1 = n2;
    		n2 = n3;
		}
		n3 = n1;
    	n2 = head;
    	boolean res = true;
    	while (n1 != null && n2 != null) {
			if (n1.val != n2.val) {
				res = false;
				break;
			}
			n1 = n1.next;
			n2 = n2.next;
		}

		return res;

    }
}