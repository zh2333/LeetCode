package com.model.graph;

import com.leetcode.datastructure.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.println(curr.val);
            for (Node next:curr.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
