package com.leetcode.p234;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.datastructure.ListNode;

/**
 * 判断一个链表是否是回文链表:
 * 请判断一个链表是否为回文链表。
	示例 1:
	
	输入: 1->2
	输出: false
	示例 2:
	
	输入: 1->2->2->1
	输出: true
 * @author 张恒
 *
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
    	
    	List<Integer> list = new ArrayList();
    	ListNode t = head;
    	//将链表节点添加到集合list中
    	while(t != null){
    		list.add(t.val);
    		t = t.next;
    	}
    	
    	//使用双指针法
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