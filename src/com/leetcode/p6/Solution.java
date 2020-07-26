package com.leetcode.p6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Z字行变换
 * 核心:找到箭头变换方向的条件
 * @author 张恒
 *
 */
public class Solution {

	public static void main(String[] args) {
		

	}

    public String convert(String s, int numRows) {
    	//1.创建numRows个StringBuilder用于存放每一行的字符串
    	if(s.length() < 2 || numRows < 2) return s;
    	List<StringBuilder> rows = new ArrayList<StringBuilder>();
    	for( int i=0; i<numRows;i++){
    		rows.add(new StringBuilder());
    	}
    	
    	//根据箭头的方向将字符串分拆成numRows个子字符串
    	int i=0;
    	int flag = -1;//控制箭头的方向,向下为+1,向上或者向右是-1
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
