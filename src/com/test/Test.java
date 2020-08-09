package com.test;

import com.leetcode.datastructure.ListNode;

import java.util.HashMap;

public class Test {
    @org.junit.Test
    public void test() {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        map.put(1, n1);
        map.put(1, n2);
        System.out.println(map.get(1).val);
    }
}
