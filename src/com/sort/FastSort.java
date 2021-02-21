package com.sort;

public class FastSort {
    /**
     * 快排
     * 执行用时 :5 ms, 在所有 Java 提交中击败了97.87%的用户
     * 内存消耗 :47.6 MB, 在所有 Java 提交中击败了7.38%的用户
     * 快速排序
     * @param nums
     * @param low
     * @param high
     */
    public static void quickSort(int[] nums,int low,int high){
        int i = low;
        int j = high;
        int tmp;
        if(i<j){
            tmp = nums[low];
            while(i<j){
                //从右向左找打一个数小于tmp,放在tmp的左边
                while(i<j && nums[j] > tmp) --j;
                if(i<j){
                    nums[i] = nums[j];
                    ++i;
                }
                //从左向右找到一个数大于tmp
                while(i<j && nums[i] < tmp) ++i;
                if(i<j){
                    nums[j] = nums[i];
                    --j;
                }
            }
            nums[i] = tmp;
            quickSort(nums, low, i-1);//对左边进行排序
            quickSort(nums, i+1, high);
        }
    }

}
