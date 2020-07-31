package com.leetcode.p86;

import org.junit.Test;

import com.leetcode.datastructure.ListNode;
import com.leetcode.utils.List;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

	你应当保留两个分区中每个节点的初始相对位置。
	
	示例:
	
	输入: head = 1->4->3->2->5->2, x = 3
	输出: 1->2->2->4->3->5
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/partition-list
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张恒
 *
 */
public class Solution {
	@Test
	public void test() {
		ListNode head = List.generateList(10);
		List.printList(head);
		head = partition(head, 6);
		List.printList(head);	
	}
	public ListNode partition(ListNode head, int x) {
		if(head == null) return null;
		if(head.next == null) return head;
		
		ListNode minHead = new ListNode(0);
		ListNode minMove = minHead;
		ListNode maxhead = new ListNode(0);
		ListNode maxMove = maxhead;
		ListNode move = head;
		//将大于等于x的节点和小于x的节点分别存放到两个链表中
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
