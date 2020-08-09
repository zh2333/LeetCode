package com.offer.reviewe22;

import com.leetcode.datastructure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head;
        ListNode later = head;
        for (int i = 0; i < k; i++) {
			former = former.next;
		}
        while(former != null){
        	former= former.next;
        	later = later.next;
        }
        return later;
    }
}