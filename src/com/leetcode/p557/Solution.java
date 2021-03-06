package com.leetcode.p557;

import org.junit.Test;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    @Test
    public void test() {
        String str = "Let's take LeetCode contest";
        System.out.println(reverseWords(str));;
    }
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder res= new StringBuilder();
        sb.reverse();
        String[] strs = sb.toString().split(" ");
        int i = 0;
        int j = strs.length - 1;
        while (i < j) {
            String tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
            i++;
            j--;
        }
        for (int k = 0; k < strs.length; k++) {
            res.append(strs[k] + " ");
        }
        return res.toString().trim();
    }
}
