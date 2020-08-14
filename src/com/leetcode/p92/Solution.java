package com.leetcode.p92;

import org.junit.Test;

import com.leetcode.datastructure.ListNode;
import com.leetcode.utils.MyList;


/**
 * 
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

	说明:
	1 ≤ m ≤ n ≤ 链表长度。

	示例:

	输入: 1->2->3->4->5->NULL, m = 2, n = 4
	输出: 1->4->3->2->5->NULL

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head == null ) return null;
    	if(head.next == null) return head;
		int steps = 1;
		
		ListNode pre = head;
		ListNode prePre = head;
		
		
		//找到需要反转的部分的第一个节点的前面一个节点
		while(steps < m - 1) {
			prePre = prePre.next;
			steps++;
		}
		if(m != 1) {
			//找到第一个节点
			pre = prePre.next;
			steps++;
		}
		
		
		//找到需要反转的部分的最后一个节点
		ListNode las = pre;
		while(steps < n ) {
			las = las.next;
			steps++;
		}
		
		ListNode lasNext = null;
		//保存最后一个节点的下一个节点
		if(las.next != null) {
			lasNext = las.next;
		}
		las.next = null;
		reverse(pre);
		
		
		
    	if(m == 1) {
    		pre.next = lasNext;
    		return las;
    	} else {
    		prePre.next = las;
    		pre.next = lasNext;
    		return head;
    	}
    }
    
    public ListNode reverse(ListNode head) {
    	ListNode pre = null;
        ListNode curr = head;
        ListNode tmp = null;
        while(curr != null){
            tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }
    
    public static void main(String[] args) {
    	MyList list = new MyList();
    	Solution so = new Solution();
    	ListNode head = list.generateList(1);
    	head = so.reverseBetween(head, 1, 2);
    	list.printList(head);
	}
}
