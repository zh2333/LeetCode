package com.leetcode.p316;

import org.junit.Test;

import java.util.Stack;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    @Test
    public void test() {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }
    public String removeDuplicateLetters(String s) {
        StringBuilder res = new StringBuilder();
        int len = s.length();

        Stack<Character> stack = new Stack<>();//使用栈保持字符之间的相对位置
        boolean[] isContainsInStack = new boolean[256];
        int[] count = new int[256];
        for (int i = 0; i < len; i++) {//记录一下每个字符的数量
            count[s.charAt(i)]++;
        }

        char[] chars = s.toCharArray();

        for (int i = 0; i < len; i++) {//遍历每一个字符
            count[chars[i]]--;

            if (!isContainsInStack[chars[i]]) {//如果还没有入栈, 准备入栈
                //判断如果栈顶元素的字典序大于当前遍历的元素, 并且在后面还有该栈顶元素, 则将栈顶元素出栈, 保留后面的元素
                while (!stack.isEmpty() && stack.peek() > chars[i]) {
                    if (count[stack.peek()] != 0) {
                        isContainsInStack[stack.pop()] = false;//如果后面还有该栈顶元素, 将栈顶元素出栈, 并把标志位只为false
                    } else {
                        break;
                    }
                }

                //将当前元素入栈, 并将标志位只为true, 表示已经入栈
                stack.push(chars[i]);
                isContainsInStack[chars[i]] = true;

            }
        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}
