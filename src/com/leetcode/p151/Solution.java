package com.leetcode.p151;

/**
 * ��ת�ַ����е�ÿ������
 * @author �ź�
 *
 */
class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" "); // ɾ����β�ո񣬷ָ��ַ���
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // ������������б�
            if(strs[i].equals("")) continue; // �����յ���������
            res.append(strs[i] + " "); // ������ƴ���� StringBuilder
        }
        return res.toString().trim(); // ת��Ϊ�ַ�����ɾ��β���ո񣬲�����
    }
}

