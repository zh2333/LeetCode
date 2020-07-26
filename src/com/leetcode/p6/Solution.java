package com.leetcode.p6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Z���б任
 * ����:�ҵ���ͷ�任���������
 * @author �ź�
 *
 */
public class Solution {

	public static void main(String[] args) {
		

	}

    public String convert(String s, int numRows) {
    	//1.����numRows��StringBuilder���ڴ��ÿһ�е��ַ���
    	if(s.length() < 2 || numRows < 2) return s;
    	List<StringBuilder> rows = new ArrayList<StringBuilder>();
    	for( int i=0; i<numRows;i++){
    		rows.add(new StringBuilder());
    	}
    	
    	//���ݼ�ͷ�ķ����ַ����ֲ��numRows�����ַ���
    	int i=0;
    	int flag = -1;//���Ƽ�ͷ�ķ���,����Ϊ+1,���ϻ���������-1
    	for(char c:s.toCharArray()){
    		rows.get(i).append(c);
    		if(i == 0 || i == numRows - 1){
    			flag = -flag;
    		}
    		i += flag;
    	}
    	
    	StringBuilder newString = new StringBuilder();
    	for (StringBuilder row : rows) {
			newString.append(row);
		}
		return newString.toString();

    }

}
