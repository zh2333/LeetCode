package com.leetcode.p18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ���������֮��,����ֻ����������һ��ѭ��
 * @param i j=i+1 L=j+1 R=len-1
 * @author �ź�
 *
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);//����
        int len = nums.length;

        if(nums==null||len<4)//����С���ģ�ֱ�ӷ��ء�������������û�г���С���ĵģ�ȥ��Ҳ��
            return result;
        for(int i=0;i<len-3;++i){
            if(nums[i]>target/4)//��С����������target��1/4������Ĳ��ÿ���
                break;
            if(i>0 && nums[i]==nums[i-1])//ȥ��
                continue;
            for(int j=i+1;j<len-2;++j){
                if(j>i+1 && nums[j]==nums[j-1])//ȥ��
                    continue;
                int low = j+1;
                int high = len-1;
                while(low<high){
                    //System.out.println(low);
                    if(nums[high]<target/4)//���Ķ�С��targer��1/4������Ĳ��ÿ���
                        break;
                    int sum = nums[i]+nums[j]+nums[low]+nums[high];
                    if(sum==target){
             
                        result.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        while(low<high && nums[low] == nums[low+1]) ++low;//������ͬ��ֵ
                        while(low<high && nums[high] == nums[high-1]) --high;//������ͬ��ֵ
                        ++low;
                        --high;
                    }else if(sum<target){//��С��Ŀ��ֵ��low����ʹ������
                        while(low<high && nums[low] == nums[low+1]) ++low;
                        ++low;
                    }else{//�ʹ���Ŀ��ֵ��high��С��ʹֵ��С
                        while(low<high && nums[high] == nums[high-1]) --high;
                        --high;
                    }
                }
            }
        }
        return result;
    }
}