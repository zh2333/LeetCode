package com.leetcode.p90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ�����ܰ����ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
	˵�����⼯���ܰ����ظ����Ӽ���
	ʾ��:
	����: [1,2,2]
	���:
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]
 * @author �ź�
 *
 */
public class Solution {
	public static void main(String[] args) {
		int[] x = {1,1,2,2,2,3,4,5,5,5,6};
		List<List<Integer>> re = subsetsWithDup(x);
		for (List<Integer> list : re) {
			for (Integer integer : list) {
				System.out.print(integer);
			}
			System.out.println();
		}
		
	}
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<String> ans = new ArrayList<String>();
        int len = nums.length;
        int n = 1<<len;
        //0-7��˸����ֻ���ɶ��������ÿ��Ա�ʾ8���Ӽ�.ÿ���Ӽ�����Ӧ��bitλ0,1����ǲ�һ����
        for (int i = 0; i < n; i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < len; j++)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            String srtList = listToString(sub);
            if(!ans.contains(srtList)){
            	ans.add(srtList);
            	res.add(sub);
            } 
        }
       
        return res;
    }
    
    public static String listToString(List<Integer> l1){
    	Object[] o1 = l1.toArray();
    	Arrays.sort(o1);
		StringBuilder sb1 = new StringBuilder();
		for (int k = 0; k < o1.length; k++) {
			sb1.append(o1[k]);
		}
		return sb1.toString();
    }
}