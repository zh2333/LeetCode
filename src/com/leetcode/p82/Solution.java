package com.leetcode.p82;

import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;
import com.leetcode.datastructure.ListNode;
import com.leetcode.utils.List;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

	示例 1:
	
	输入: 1->2->3->3->4->4->5
	输出: 1->2->5
	示例 2:
	
	输入: 1->1->1->2->3
	输出: 2->3
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张恒
 *
 */
public class Solution {
	@Test
	public void dupTest() {
		int wrongCount = 0;
		for(int i = 0; i < 1000000; i++) {
			try{
				test();
			}catch(Exception e) {
				wrongCount++;
			}
		}
		System.out.println("出错次数：" + wrongCount);
	}
	
	
	public void test() {
		ListNode head = List.generateList(6);
		List.printList(head);
		head = deleteDuplicates(head);
		List.printList(head);
	}
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
		HashMap<Integer, Integer> map = new HashMap<>();
		ListNode movePointer = head;
		boolean hasDupNode = false;
		while(movePointer != null) {
			int currVal = movePointer.val;
			if(map.containsKey(currVal)) {
				map.put(currVal, map.get(currVal) + 1);
				hasDupNode = true;
			} else {
				map.put(currVal, 1);
			}
			movePointer = movePointer.next;
		}
		//如果没有重复元素，则不进行接下来的步骤， 直接返回链表头
		if(!hasDupNode) {
			return head;
		}
		HashSet<Integer> duplicatedItems = new HashSet<>();
		for(Integer key : map.keySet()) {
			if(map.get(key) > 1) {
				duplicatedItems.add(key);
			}
		}
		
		//考虑链表头部为重复元素的情况
		while(head!= null && duplicatedItems.contains(head.val)) {
			head = head.next;
		}
		//如果整个链表中的元素都是重复的， 直接返回null
		if(head == null) {
			return null;
		}
		// 假设head不是重复元素或者到达第一个不是重复元素的节点
		ListNode pre = head;
		ListNode currNode = pre.next;
		while(currNode != null) {
			if(duplicatedItems.contains(currNode.val)){
				currNode = currNode.next;
			} else {
				pre.next = currNode;
				currNode = currNode.next;
				pre = pre.next;
			}
		}
		//currNode为空且pre.next 是重复元素， 则表明pre接下来的元素都是重复元素， 直接将pre.next置为null
		if(pre.next!=null && duplicatedItems.contains(pre.next.val)) {
			pre.next = null;
		}
		return head;
    }
}
