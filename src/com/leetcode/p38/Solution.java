package com.leetcode.p38;

import org.junit.Test;

/**
 * 外观数列
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：

	1.     1
	2.     11
	3.     21
	4.     1211
	5.     111221
	1 被读作  "one 1"  ("一个一") , 即 11。
	11 被读作 "two 1s" ("两个一"）, 即 21。
	21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
	给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
	注意：整数序列中的每一项将表示为一个字符串。
 * @author 张恒
 *
 */
public class Solution {
	@Test
	public void test(){
		System.out.println(countAndSay(4));
	}
	
    public static String countAndSay(int n) {
    	//定义起始串
    	String sequence = "1";
    	//每次支循环n-2次
    	for (int i = 1; i < n; i++) {
			//每计数完一个数字就更新sequence作为下一次循环的参数
    		sequence = describe(sequence.toCharArray());
		}
        return sequence;
    }
    public static String describe(char[] chars) {
		StringBuilder sb = new StringBuilder();
		int count=1;
		int index=1;
		char chCurr = chars[0];//表示当前要计数的数字
		while(index < chars.length){
			char temp = chars[index];
			//如果一样计数值就+1
			if(chCurr == temp){
				count++;
			//否则表示当前计数的数字已经结束
			//需要更新chCurr,计数值count,并将计数完成的数字存起来
			}else{
				sb.append(count);
				sb.append(chars[index-1]);
				chCurr = chars[index];
				count = 1;
			}
			index++;
		}
		//将最后一段计数结束的数字及其计数结果存起来.例如1211的11部分
		sb.append(count);
		sb.append(chars[index-1]);
        return sb.toString();
    }
}

