package com.leetcode.p8;

/**
 * 將字符串中遇到的第一個非字母數字提取出來
 * 条件:
 * 1.遇到空格继续遍历
 * 2.遇到-或+则判断其下一个是否为数字,如果是继续遍历,如果不是返回0
 * 3.字符串除空格之外的第一个字符是字母,return 0
 * 4.最后判断是否溢出
 * @author 张恒
 *
 */
class Solution {
    public int myAtoi(String str) {
        int rev = 0;
        char[] charList = str.toCharArray();
        int length = str.length();
        int zf = 1;
        int i = 0;
        int pop = 0;
        for(;  i < length; i++){
            if(charList[i] == ' '){
                continue;
            }else{
                if(charList[i] == '-'){
                    i++;
                    zf = -1;
                    break;
                }
                if(charList[i] == '+'){
                    i++;
                    break;
                }
                if(charList[i] <'0' || charList[i] >'9'){
                    return 0;
                }else{
                    break;
                }
            }
        }
        if(i == length){
            return 0;
        }
        for(;i < length; i++){
            if(charList[i] <'0' || charList[i] >'9'){
                return rev;
            }
            pop = (charList[i] -48) * zf;
            if(rev>Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)){
                return Integer.MAX_VALUE;
            }
            if(rev<Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)){
                return Integer.MIN_VALUE;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}