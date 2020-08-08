package com.sort;

import org.junit.Test;

public class InsertSort {
    /**
     * 插入排序
     * @param nums
     * @return
     */
     public int[] insertSort(int[] nums) {
         int len = nums.length;
         for (int i = 1; i < len; i++) {
             int currNum = nums[i];
             int j = i - 1;
             while(j>=0 && nums[j] >= currNum){
                 nums[j+1] = nums[j];
                 j--;
             }
             nums[j+1] = currNum;
         }
         return nums;
     }
}
