package com.leetcode.p19;

import com.leetcode.datastructure.ListNode;

/**
 * 删除链表的倒数第n个节点
 * 使用两个间隔为n的指针,让两个指针同时向后移动,当后面指针到达尾部时
 * 前面一个指针的下一个元素正好是要删除的元素
 * @author 张恒
 *
 */
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode pre = new ListNode(0);//这一步也很关键,避免了多余的判断
		pre.next = head;
		ListNode start = pre;
		ListNode end = pre;
		
		//后一个指针开始向后移动
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
