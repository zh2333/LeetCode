package com.leetcode.p40;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import org.junit.Test;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
	candidates 中的每个数字在每个组合中只能使用一次。
	说明：
	所有数字（包括目标数）都是正整数。
	解集不能包含重复的组合。
	 
	示例 1:
	输入: candidates = [10,1,2,7,6,1,5], target = 8,
	所求解集为:
	[
	  [1, 7],
	  [1, 2, 5],
	  [2, 6],
	  [1, 1, 6]
	]
	
	示例 2:
	输入: candidates = [2,5,2,1,2], target = 5,
	所求解集为:
	[
	  [1,2,2],
	  [5]
	]

 * @author 张恒
 *本题和39题的区别在于数组中重复的元素不能使用,且当前元素只能使用一次
 */
public class Solution {
	@Test
	public void test(){
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> res = combinationSum2(candidates, target);
		for (List<Integer> list : res) {
			for (Integer integer : list) {
				System.out.println(integer);
			}
			System.out.println("");
		}
	}
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> res = new ArrayList();
    	int len = candidates.length;
    	if(len == 0) return res;
    	//排序,为了后序的剪枝.当剩余值大于candidates[i]时,表示后面也不用搜索了,不可能找到了
    	Arrays.sort(candidates);
    	
    	dfs(candidates, len, target, 0, new ArrayDeque<>(), res);
    	
		return res;

    }
    
    
    /**
     * 
     * @param candidates  候选数组
     * @param len 	数组的长度
     * @param residue	剩余值
     * @param begin	搜索开始的起点下标
     * @param path	搜索得到的可行的路径
     * @param res	可行路径的集合
     */
    public static void dfs(int[] candidates,int len,int residue,int begin,Deque<Integer> path,List<List<Integer>> res){
    	//如果residue==0,表名已经找了,这条路径可行,将路径加入res
    	if(residue==0){
    		res.add(new ArrayList<Integer>(path));
    		return;
    	}
    	
    	
    	//从当前节点开始搜索
    	for(int i=begin;i<len;i++){
    		
    		//大剪枝操作.跳出循环,本次搜索提前结束
    		if(residue < candidates[i]) break;
    		//小剪枝操作,跳过数组中相同的元素
    		if(i>begin && candidates[i] == candidates[i-1]) continue;
    		
    		//把节点放进添加到当前路径中
    		path.addLast(candidates[i]);
    		//从下一个节点开始搜索
    		dfs(candidates, len, residue-candidates[i], i+1, path, res);
    		//回溯,返回上一层节点从上层节点重新开始搜索
    		path.removeLast();
    	}
    }
}

