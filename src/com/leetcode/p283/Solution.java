package com.leetcode.p283;

/**
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
	ʾ��:
	����: [0,1,0,3,12]
	���: [1,3,12,0,0]
	˵��:
	
	������ԭ�����ϲ��������ܿ�����������顣
	�������ٲ���������
 * @author �ź�
 *
 */

class Solution {
	public static void main(String[] args) {
		int[] nums={1,3,12,0,0};
		moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
	}
    public static void moveZeroes(int[] nums) {
    	if(nums == null) return;
    	
    	int j=0;
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i] != 0){
				int temp = nums[i];
				nums[i]=nums[j];
				nums[j++]=temp;
			}
		}
    	
    }
}