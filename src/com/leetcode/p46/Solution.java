package com.leetcode.p46;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

/**
 * ����һ��û���ظ����ֵ����У����������п��ܵ�ȫ���С�
	ʾ��:
	����: [1,2,3]
	���:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
 * @author �ź�
 *	���:���뷨,ÿ�ν�Ԫ�ز��뵽��֪���еļ�϶��
 */
class Solution {
	
	static List<List<Integer>> permute = new ArrayList();
	static List<Integer> list = new ArrayList();
	
    public static List<List<Integer>> permute(int[] nums) {
    	generatePermute(nums, 1, nums.length);
    	return permute;
    }
    
    public static void generatePermute(int[] nums,int currentIndex,int len){
    	//�����ǰλ�ô������鳤�ȱ����Ѿ������˵ݹ�����һ��
    	//���б��е�Ԫ����ӵ�ȫ���м�����
    	if(currentIndex > len){
    		//�����µ���������Ϊlist��ȫ�ֵ�,��һֱ�ڱ仯.��list�е�Ԫ��ȫ����������ʱ������
    		List<Integer> listemp = new ArrayList();
    		for (Integer item : list) {
    			listemp.add(item);
			}
    		permute.add(listemp);
    		return;
    	}
    	
    	//��Ȼû�е���ݹ���ײ�,��������֪list�е�Ԫ���еļ�϶�����Ԫ��
    	for (int i = 0; i <= currentIndex; i++) {
			list.add(i, nums[currentIndex-1]);
			generatePermute(nums, currentIndex+1, len);
			//�ϲ�ִ���굽��ݹ�ײ�֮��,���˻ص���һ��,�ѵ�ǰλ�õ�Ԫ�ش�list���޳�
			list.remove(currentIndex);
		}
    }
}