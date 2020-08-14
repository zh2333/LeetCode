package com.leetcode.p41;

import com.leetcode.utils.MyArray;

public class Solution {
	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		if(len == 0) return 1;
		
		//��iλ�ô���Ԫ�ؽ�����nums[i] - 1����λ�ã� �������λ�ô���Ԫ��ֵ��������轻��
		for(int i = 0; i < len; i++) {
			while(nums[i] > 0 && nums[i] < len && nums[i] != nums[nums[i] - 1]) {
				MyArray.swap(nums, i, nums[i] - 1);
			}
		}
		
		//��ͷ��ʼ ������ �����ǰλ��i����Ԫ�غ�nums[i] �������ϵ nums[i] - 1 = i, �������ǰλ��i+1���Ԫ����ȱʧ��
		for(int i = 0; i < len ; i++) {
			if(nums[i] != i + 1) {
				return i + 1;
			}
		}
		//˵������Ԫ�ض�����Ӧ���ڵ�λ��
		return len + 1;
    }

}
