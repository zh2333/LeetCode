package com.leetcode.p917;

import com.leetcode.utils.StringUtil;
import org.junit.Test;

/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *  
 *
 * 提示：
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    @Test
    public void test() {
        String s = StringUtil.generateStr(10);
        StringUtil.printStr(s);
        String newStr = reverseOnlyLetters(s);
        StringUtil.printStr(newStr);

    }
    public String reverseOnlyLetters(String S) {
        int len = S.length();
        char[] chars = new char[len];
        //1.将整个字符串存入字符数组
        for (int i = 0; i < len; i++) { //将字符串中的字符存入字符数组
            chars[i] = S.charAt(i);
        }
        //2.将整个字符串翻转
        reverseStr(chars, len);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    /**
     * 翻转字符串, 遇到非英文字符不变
     * @param chars
     */
    public void reverseStr(char[] chars, int len) {
        int i = 0;
        int j = len - i - 1;
        while(i <= j) {
            char c1 = chars[i];
            char c2 = chars[j];
            if(isLetter(c1) && isLetter(c2)) {
                System.out.println(c1+" <==> " + c2);
                char tmp = c1;
                chars[i++] = c2;
                chars[j--] = tmp;
            } else if(!isLetter(c1) && !isLetter(c2)) {
                i++;
                j--;
            } else if(!isLetter(c1)) {
                i++;
            } else {
                j--;
            }
        }
    }

    public boolean isLetter(char c) {
        return (c >= 97 && c <= 122) || (c >= 65 && c <= 90);
    }

}
