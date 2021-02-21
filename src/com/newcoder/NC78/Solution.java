package com.newcoder.NC78;

import com.leetcode.datastructure.ListNode;
import com.leetcode.utils.MyList;
import org.junit.Test;

public class Solution {

    @Test
    public void test() {
        ListNode head = MyList.generateList(5);
        MyList.printList(head);
        head = ReverseList(head);
        MyList.printList(head);
    }
    public ListNode ReverseList(ListNode head) {
        //头结点为空, 只有一个节点
        if (head == null || head.next == null) {
            return head;
        }
        //链表节点数量>=2
        ListNode pre = head;
        ListNode curr = head.next;
        pre.next = null;//链表第一个节点变成最后一个节点， next域为空
        while (curr.next != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
            tmp = tmp.next;
        }
        curr.next = pre;
        return curr;
    }
}
