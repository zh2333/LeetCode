package com.leetcode.p416;

import com.leetcode.utils.MyArray;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5,6,7};
//        MyArray.printArray(nums);
//        Arrays.sort(nums);
//        MyArray.printArray(nums);
        boolean flag = canPartition(nums);
        System.out.println(flag);

    }

    /**
     * 01背包问题:
     * 考虑在容量为j情况下, 在前i件物品中选择一部分使得价值最大
     * 在本问题中可以理解为:
     * 考虑在容量为target(数组和一半)的情况下, 在前i个数组元素中选择一部分使得和最大
     * 这个问题可以分成两种情况:
     * 1. 不选择第i个物品, 那么f[i][j] = f[i - 1][j]; 如果不选择第i键物品, 那么在容量为j前提下, 考虑前i件物品和考虑前i - 1件物品得到的最大价值是一样的
     * 2. 选择第i个物品, 那么 f[i][j] = f[i - 1][j - v[i]] + w[i]; 如果选择第i件物品, 那么f[i][j] 就等于在容量为j - v[i] 的前提下, 考虑前i - 1件物品得到的最大价值加上第i件物品的价值
     * f[i][j]选择1和2中最大的情况
     *换成是在本问题中, 也可以分为两种情况:
     * 1. 不选择第i个数, 那么 f[i][target] = f[i - 1][target]; 如果不选择第i个数, 那么在容量为target的前提下, 考虑前i个数和考虑前i - 1个数得到的最大价值是一样的
     * 2. 选择第i个数, 那么f[i][target] = f[i - 1][target - v[i]] + v[i]; 如果选择第i个数, 那么f[i][j]等于在容量为target - v[i] 的前提下考虑前i - 1个数得到的最大值加上第i个数的值
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int maxSum = 0;
        for (int num: nums ) {
            sum += num;
            maxSum = maxSum < num ? num :maxSum;
        }
        int target = sum / 2;
        int[][] res = new int[len][target + 1];
        if (sum % 2 != 0 || len == 0 || len == 1 || maxSum > target) {
            return false;
        }
        res[0][nums[0]] = nums[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                if (j > nums[i]) {
                    res[i][j] = Math.max(res[i - 1][j], res[i - 1][j - nums[i]] + nums[i]);
                } else {
                    res[i][j] = res[i - 1][j];
                }
            }
        }
        System.out.println(res[len - 1][target]);
        return res[len - 1][target] == target;//在容量为target的前提下, 考虑前len - 1个数得到的最大值是否等于target
    }
}
