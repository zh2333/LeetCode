package com.leetcode.p21;

import com.leetcode.datastructure.ListNode;
import com.leetcode.utils.MyList;
import org.junit.Test;

public class Solution {

    @Test
    public void test() {
        ListNode l1 = MyList.generateSortedList(0, 5);
        MyList.printList(l1);
        ListNode l2 = MyList.generateSortedList(3, 4);
        MyList.printList(l2);
        ListNode head = mergeTwoLists(l1, l2);
        MyList.printList(head);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else  {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
