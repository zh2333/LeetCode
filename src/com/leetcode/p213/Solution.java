package com.leetcode.p213;


import com.leetcode.utils.MyArray;
import org.junit.Test;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 示例 1:
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 示例 2:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = {1,2,3,1};
        int res = rob(nums);
        System.out.println(res);
    }

    /**
     * 环形数组意味着数组头和数组尾部不能同时被选中:
     * 1. 头被选中, 尾部没有被选中
     * 2. 头部没有被选中, 尾部被选中
     * 3. 头部, 尾部均没有被选中
     * 第三种情况是前两种情况的交集.因此只需要考虑前两种情况即可.
     * 将环形数组拆分成两个数组: 0 ~ n-2  |  1 ~ n - 1;取两者中的最大值即可
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        } else if (len == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] nums1 = Arrays.copyOfRange(nums, 0, len - 1);//[)左闭右开
        MyArray.printArray(nums1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, len);
        MyArray.printArray(nums2);
        return Math.max(helper(nums1), helper(nums2));
    }
    public  int helper(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;

        //dp数组记录当前房屋可以盗的的最大金额
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[len];
    }
}
