package com.newcoder.NC4;

import com.leetcode.datastructure.ListNode;
import org.junit.Test;

/**
 * 题目描述
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * 你能给出O(1)空间复杂度的解法么？
 */
public class Solution {
    @Test
    public void test() {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next= n1;
        System.out.println(hasCycle(n1));
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
