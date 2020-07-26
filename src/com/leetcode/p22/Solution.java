package com.leetcode.p22;

import java.util.LinkedList;
import java.util.List;

/**
 * ��������:����n������,ö�ٳ����еĿ�����
 * ���:����
 * ��ʣ�������ŵ���������ʣ�������ŵ�����ʱ,���ȷ���������,Ȼ�����������
 * ÿ�εݹ鵱�����ŵ���������0ʱ������ַ�����ӵ�list��
 * @author �ź�
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
