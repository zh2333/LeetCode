package com.leetcode.p39;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
	candidates 中的数字可以无限制重复被选取。
	说明：
	所有数字（包括 target）都是正整数。
	解集不能包含重复的组合。 
	示例 1:
	输入: candidates = [2,3,6,7], target = 7,
	所求解集为:
	[
	  [7],
	  [2,2,3]
	]
	
	示例 2:
	输入: candidates = [2,3,5], target = 8,
	所求解集为:
	[
	  [2,2,2,2],
	  [2,3,3],
	  [3,5]
	]
	
 * @author 张恒
 *解决:建立深度优先搜索树,并对树上的不合适的支进行剪枝操作
 */
public class Solution {
	@Test
	public void test(){
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> res = combinationSum(candidates, target);
		for (List<Integer> list : res) {
			for (Integer integer : list) {
				System.out.println(integer);
			}
			System.out.println("");
		}
	}
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
    		
    		//剪枝操作.跳出循环,本次搜索提前结束
    		if(residue < candidates[i]){
    			break;
    		}
    		
    		//把节点放进添加到当前路径中
    		path.addLast(candidates[i]);
    		dfs(candidates, len, residue-candidates[i], i, path, res);
    		//回溯,返回上一层节点从上层节点重新开始搜索
    		path.removeLast();
    	}
    }
}
