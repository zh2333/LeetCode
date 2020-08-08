package com.leetcode.p25;

import org.junit.Test;

import com.leetcode.datastructure.ListNode;
import com.leetcode.utils.List;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
	k 是一个正整数，它的值小于或等于链表的长度。
	如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
	示例：
	
	给你这个链表：1->2->3->4->5
	
	当 k = 2 时，应当返回: 2->1->4->3->5
	
	当 k = 3 时，应当返回: 3->2->1->4->5
	说明：
	
	你的算法只能使用常数的额外空间。
	你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张恒
 *
 */
public class Solution {
	@Test
	public void dupTest() {
		int wrong = 0;
		for(int i = 0; i < 10000;i++) {
			int listLen = (int) (Math.random() * 20);
			int gap = (int)(Math.random() * 10);
			try{
				test(listLen, gap);
			} catch (Exception e) {
				wrong++;
			}
		}
		System.out.println("错误次数: " + wrong);
	}
	
	
	public void test(int listLen, int gap){
		System.out.println("链表长度:" + listLen);
		System.out.println("每隔: " + gap +" 个节点翻转一次");
		ListNode head = List.generateList(listLen);
		List.printList(head);
		head = reverseKGroup(head, gap);
		List.printList(head);
	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
       if(head == null || k == 0) return head;
       
       int len = 0;
       ListNode move = head;
       while(move != null) {
    	   len++;
    	   move = move.next;
       }
       if(k > len) return head;
       int count = (int)(len / k);//表示要反转多少次
       int tmpCount = count;
       ListNode startNode = head;
       ListNode endNode = startNode;
    
       while(count > 0) {
    	   endNode = findConnect(startNode, k, count);
    	   if(tmpCount == count ) {
    		   head = endNode;//第一次反转的子链表的尾结点是反转结束后链表的头结点
    	   }
    	   count--;
    	   startNode =  reverse(startNode, endNode, k, count);
    	   endNode = startNode;
    	   
       }
        return head;
    }
    
    public ListNode reverse(ListNode startNode, ListNode endNode, int k, int count) {
    	ListNode endNodeNext = endNode.next;
    	ListNode pre = null;
        ListNode curr = startNode;
        ListNode tmp = null;
        while(curr != endNodeNext){
            tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        
        startNode.next = findConnect(endNodeNext, k,  count);//当前子链表反转结束后的尾结点的下一个节点是下一节子链表开始反转的尾结点
        return endNodeNext;
    }
    
    /**
     * 从子链表头开始找到子链表尾部
     * @param startNode
     * @param k 移动多少步才能找到子链表尾部
     * @param count 如果count为0, 则表示最后一节不需要翻转了, 直接返回最后一节的头结点即可
     * @return
     */
    public ListNode findConnect(ListNode startNode, int k, int count) {
    	if(count == 0) return startNode;
    	
        ListNode endNode = startNode;
    	int tmp = 1;
 	    while(tmp < k && endNode != null) {
 		   if(endNode.next != null) {
 			  endNode = endNode.next;
 	 		  tmp++;
 		   } else {
 			   break;
 		   }
 		  
 	   }
 	   return endNode;
    }
    
    
}