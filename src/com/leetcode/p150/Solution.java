package com.leetcode.p150;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

/**
 * 根据 逆波兰表示法，求表达式的值。

有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
	说明：
	
	整数除法只保留整数部分。
	给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
	 
	
	示例 1：
	
	输入: ["2", "1", "+", "3", "*"]
	输出: 9
	解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
	示例 2：
	
	输入: ["4", "13", "5", "/", "+"]
	输出: 6
	解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张恒
 *
 */
public class Solution {
	@Test
	public void test() {
		String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(evalRPN(tokens));
	}
	public int evalRPN(String[] tokens) {
		Set<String> operators = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
		for(String s : tokens) {
			if(!operators.contains(s)) {
				stack.add(Integer.valueOf(s));
			} else {
				computeByOperator(s, stack);
			}
		}
		return stack.pop();
    }
	
	public void computeByOperator(String operator, Stack<Integer> stack) {
		Integer secondOperand = stack.pop();
		Integer firstOperand = stack.pop();
		switch(operator) {
			case "+":			
				stack.add(firstOperand + secondOperand); 
				break;
			case "-":			
				stack.add(firstOperand - secondOperand);
				break;
			case "*":			
				stack.add(firstOperand * secondOperand);
				break;				
			case "/":				
				stack.add((int)firstOperand / secondOperand);
				break;
		}
		
	}

}
