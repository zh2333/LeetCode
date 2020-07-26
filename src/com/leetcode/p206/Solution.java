package com.leetcode.p206;

import com.leetcode.datastructure.ListNode;
/**
 * 原地反转单链表
 * 解决:
 * 每次让当前节点指向其前一个节点
 * @author 张恒
 *
 */
class Solution {
    public ListNode reverseList(ListNode head) {
    	ListNode pre = null;
    	ListNode curr = head;
    	ListNode temp = null;
    	
    	while(curr != null){
    		//记录当前节点的下一个节点
    		temp = curr.next;
    		//让当前节点指向他前一个节点
    		curr.next = pre;
    		//更新curr和pre节点的位置
    		pre = curr;
    		curr = temp;
    	}
		return pre;

    }
}