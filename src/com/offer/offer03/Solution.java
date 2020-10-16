package com.offer.offer03;

import com.offer.utils.MyArray;
import org.junit.Test;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 限制：
 * 2 <= n <= 100000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    @Test
    public void test() {
        int[] array = MyArray.generateArray(10);
        MyArray.printArray(array);
        int rs = findRepeatNumber(array);
        System.out.println(rs);
    }
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        int[] tmpArr = new int[len];
        for (int i = 0; i < len; i++) {
            tmpArr[nums[i]] += 1;
        }

        for (int i = 0; i < len; i++) {
            if(tmpArr[i] > 1) {
                return i;
            }
        }
        return 0;
    }
}
