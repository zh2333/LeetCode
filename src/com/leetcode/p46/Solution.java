package com.leetcode.p46;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
	示例:
	输入: [1,2,3]
	输出:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
 * @author 张恒
 *	解决:插入法,每次将元素插入到已知序列的间隙中
 */
class Solution {
	
	static List<List<Integer>> permute = new ArrayList();
	static List<Integer> list = new ArrayList();
	
    public static List<List<Integer>> permute(int[] nums) {
    	generatePermute(nums, 1, nums.length);
    	return permute;
    }
    
    public static void generatePermute(int[] nums,int currentIndex,int len){
    	//如果当前位置大于数组长度表名已经到达了递归的最后一层
    	//将列表中的元素添加到全排列集合中
    	if(currentIndex > len){
    		//创建新的链表是因为list是全局的,且一直在变化.将list中的元素全部拷贝到临时链表中
    		List<Integer> listemp = new ArrayList();
    		for (Integer item : list) {
    			listemp.add(item);
			}
    		permute.add(listemp);
    		return;
    	}
    	
    	//仍然没有到达递归最底层,继续向已知list中的元素中的间隙中添加元素
    	for (int i = 0; i <= currentIndex; i++) {
			list.add(i, nums[currentIndex-1]);
			generatePermute(nums, currentIndex+1, len);
			//上步执行完到达递归底层之后,后退回到上一层,把当前位置的元素从list中剔除
			list.remove(currentIndex);
		}
    }
}