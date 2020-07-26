package com.leetcode.p22;

import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成:生成n对括号,枚举出所有的可能性
 * 解决:回溯
 * 当剩余左括号的数量多余剩余右括号的数量时,首先放置左括号,然后放置右括号
 * 每次递归当右括号的数量等于0时将这个字符串添加到list中
 * @author 张恒
 *
 */
public class Solution {
	public List<String> generateParenthesis(int n) {
        return generateParenthesisBack("",n,n);
    }
	
	List<String> list = new LinkedList();
	public List<String> generateParenthesisBack(String line, int left,int right){
		if(left > 0){
			generateParenthesisBack(line+"(",left-1,right);
		}
		if(right > left){
			generateParenthesisBack(line+")",left,right - 1);
			
		}
		
		if(right <= 0){
			list.add(line);
		}
		return list;
	}
}
