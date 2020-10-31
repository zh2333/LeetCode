package com.test;

import com.leetcode.datastructure.ListNode;
import com.leetcode.p381.RandomizedCollection;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        RandomizedCollection collection = new RandomizedCollection();
        boolean res1 = collection.insert(1);
        boolean res2 = collection.insert(1);
        boolean res3 = collection.insert(2);
        int res4 = collection.getRandom();
        boolean res5 = collection.remove(1);
        int res6 = collection.getRandom();

        System.out.println("res1: " + res1 + "\n" + "res2: " + res2 + "\n" + "res3: " + res3 + "\n" + "res4: " + res4 + "\n" + "res5: " + res5 + "\n" + "res6: " + res6 + "\n");
    }
}
