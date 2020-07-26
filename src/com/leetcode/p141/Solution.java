package com.leetcode.p141;

import com.leetcode.datastructure.ListNode;

/**
 * ��������
 * ����һ�������ж��������Ƿ��л���
	Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���
	ʾ�� 1��
	
	���룺head = [3,2,0,-4], pos = 1
	�����true
	���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
 * @author �ź�
 *���:
 *����ָ�뷨,���һ���ܵÿ�һ���ܵ���,���Ҵ��ڻ��Ļ�,������ջ�׷������
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
    	if(head == null || head.next == null) return false;
    	
    	ListNode slow = head;
    	ListNode fast = head.next;
    	
    	while(slow != fast){
    		if(fast == null || fast.next==null){
    			return false;
    		}
    		slow = slow.next;
    		fast = fast.next.next;
    	}
		return true;
    }
}