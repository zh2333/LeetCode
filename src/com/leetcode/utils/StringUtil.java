package com.leetcode.utils;

import java.util.Random;

public class StringUtil {

    /**
     * 生成指定长度的字符串
     * @param len 字符串的长度
     * @return
     */
    public static String generateStr(int len) {
        if(len == 0) {
            System.out.println("长度不能为0!");
        }
//        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k' , 'l', 'm', 'n' , 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
//                        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' , 'L', 'M', 'N' , 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
//                        '-', '=', '!', '@','#', '%' , '^', '&', '*', '+', '?', '{', '}', '[', ']', '.', ',', '|', '<', '>'};
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k' , 'l', 'm', 'n' , 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' , 'L', 'M', 'N' , 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        };
        StringBuilder sb = new StringBuilder();
        int charsLen = chars.length;
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append(chars[random.nextInt(charsLen)]);
        }
        return sb.toString();
    }

    /**
     * 打印字符串
     * @param s
     */
    public static void printStr(String s) {
        if(s == null) {
            System.out.println("空串!");
        }
        int len = s.length();
        System.out.print("\"");
        for (int i = 0; i < len; i++) {
            System.out.print(s.charAt(i));
        }
        System.out.print("\"");
    }

    /**
     * 翻转字符串
     * @param s
     * @return
     */
    public static String reverseStr(String s) {
        if(s == null) {
            System.out.println("空串!");
        }
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    /**
     * 生成字符串数组
     * @param count 数组长度
     * @return
     */
    public static String[] generateStrs(int count) {
        if (count == 0) {
            System.out.println("数组长度不能为空!");
            return null;
        }
        String[] strs = new String[count];

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int len = random.nextInt(9) + 1;
            strs[i] = generateStr(len);
        }
        return strs;
    }

    /**
     * 打印字符串数组
     * @param strs
     */
    public static void printStrs(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            System.out.println("空数组!");
            return;
        }

        System.out.print("[");
        for (int i = 0; i < len; i++) {
            printStr(strs[i]);
            if (i != len - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

