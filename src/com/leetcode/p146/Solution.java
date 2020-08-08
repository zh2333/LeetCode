package com.leetcode.p146;

import com.leetcode.datastructure.ListNode;
import com.leetcode.utils.List;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *  
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode move = head;
        ListNode node1 = new ListNode(9);
        move.next = node1;
        move = move.next;
        ListNode node2 = new ListNode(4);
        move.next = node2;
        move = move.next;
        ListNode node3 = new ListNode(2);
        move.next = node3;
        move = move.next;

        List.printList(head);
        head = insertionSortList(head);
        List.printList(head);

    }
    public ListNode insertionSortList(ListNode head) {
        //将每一个链表节点存起来
        HashMap<Integer, ListNode> map = new HashMap<>();
        ArrayList<ListNode> nodes = new ArrayList<>();

        ListNode move = head;
        int index = 0;
        while(move != null) {
            map.put(index, move);
            nodes.add(move); //vals的下标对应map中的index域
            index++;
            move = move.next;
        }

        //遍历nodes
        int len = nodes.size();
        for (int i = 1; i < len; i++) {//i表示节点在链表中原来的位置
            ListNode currNode = nodes.get(i);
            int insertPos = findInsertPos(nodes, currNode, i);

            //判断是否需要插入
            if(insertPos != i) {
                //1.将当前节点的前一个节点连接到当前节点的后一个节点
                ListNode preNode = map.get(i - 1);
                preNode.next = currNode.next;
                //判断是否需要插入
                //2.找到插入位置的前一个节点
                if(insertPos != 0) {//插入位置不在链表头部
                    ListNode preInsertPosNode = map.get(insertPos - 1);
                    currNode.next = preInsertPosNode.next;
                    preInsertPosNode.next = currNode;
                } else {//插入位置在链表头部
//                    head.next = currNode.next;
                    currNode.next = head;
                    head = currNode;//当新节点插入到链表头部时就需要更新链表
                }
            }
        }
        return head;
    }

    /**
     * 找到节点合适的插入位置
     * @param nodes
     * @return
     */
    public int findInsertPos(ArrayList<ListNode> nodes, ListNode currNode, int currIndex) {
        int len = nodes.size();
        int currVal = currNode.val;

        int k = currIndex - 1;
        while(k >= 0 && nodes.get(k).val > currVal) {
            k--;
        }
        if(k < 0) {
            return 0;
        } else {
            return k + 1;
        }
    }

    public ArrayList<ListNode> updateList(ListNode head) {
        ListNode move = head;
        ArrayList<ListNode> newList = new ArrayList<>();
        while(move != null) {
            newList.add(move);
            move = move.next;
        }
        return newList;
    }
}

