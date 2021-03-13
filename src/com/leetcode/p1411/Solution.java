package com.leetcode.p1411;

/**
 * 你有一个 n x 3 的网格图 grid ，你需要用 红，黄，绿 三种颜色之一给每一个格子上色，且确保相邻格子颜色不同（也就是有相同水平边或者垂直边的格子颜色不同）。
 * 给你网格图的行数 n 。
 * 请你返回给 grid 涂色的方案数。由于答案可能会非常大，请你返回答案对 10^9 + 7 取余的结果。
 */
public class Solution {
    private static final int MOD = 1000000007;

    public int numOfWays(int n) {
        if (n == 0) {
            return 0;
        }
        //每层的涂色可以分成ABA和ABC两类
        long ABA = 6;
        long ABC = 6;
        for (int i = 2; i <= n; i++) {
            //本层的每个ABA类 -> 下层演化为3个ABA+2个ABC
            //本层的每个ABC类 -> 下层演化为2个ABA+2个ABC
            ABC = 2 * (ABA + ABC) % MOD;
            ABA = (ABC + ABA) % MOD;
        }
        return (int) ((ABA + ABC) % MOD);
    }
}
