package com.offer.面试题50;

import java.util.HashSet;

/**
 * ���ַ��� s ���ҳ���һ��ֻ����һ�ε��ַ������û�У�����һ�����ո�

ʾ��:

s = "abaccdeff"
���� "b"

s = "" 
���� " "

 * @author �ź�
 *
 */
class Solution {
	public static void main(String[] args) {
		String s = "aadadaad";
		System.out.println(firstUniqChar(s));
	}
    public static char firstUniqChar(String s) {
    	StringBuilder sb = new StringBuilder(s);
    	sb.reverse().toString();
    	if(s  == null) return ' ';
    	HashSet<Character> set = new HashSet<>();
    	int len = s.length();
    	boolean isFind = false;
    	int i = 0;
    	while(i < len){
    		int j = i + 1;
    		while(j < len){
    			if(s.charAt(j) == s.charAt(i)){
    				isFind = true;
    				set.add(s.charAt(j));
    				break;
    			}else{
    				isFind = false;
    			}
    			j++;
    		}
    		if(!isFind && !set.contains(s.charAt(i))){
    			return s.charAt(i);
    		}
    		
    		i++;
    	}
		return ' ';

    }
}