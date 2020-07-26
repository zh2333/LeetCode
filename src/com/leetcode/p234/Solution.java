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
    	
    	List<Integer> list = new ArrayList();
    	ListNode t = head;
    	//������ڵ���ӵ�����list��
    	while(t != null){
    		list.add(t.val);
    		t = t.next;
    	}
    	
    	//ʹ��˫ָ�뷨
    	int start = 0;
    	int last = list.size() - 1;
    	while(start < last){
    		if(!list.get(start).equals(list.get(last))){
    			return false;
    		}
    		start++;
    		last--;
    	}
    	
		return true;

    }
}