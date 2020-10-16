package com.leetcode.p509;

import org.junit.Test;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

	F(0) = 0,   F(1) = 1
	F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
	给定 N，计算 F(N)。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/fibonacci-number
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张恒
 *
 */
public class Solution {

	@Test
	public void test() {
		int i = 50;
		long start1 = System.nanoTime();
		fib(i);
		long end1 = System.nanoTime();

		//带备忘录的计算
		long start2 = System.nanoTime();
		fibMemo(i);
		long end2 = System.nanoTime();

		//带备忘录的计算
		long start3 = System.nanoTime();
		fibTable(i);
		long end3 = System.nanoTime();

		System.out.println((end1 - start1) + "ms");
		System.out.println((end2 - start2) + "ms");
		System.out.println((end3 - start3) + "ms");
	}
	//暴力穷举, 效率很低, 存在重复计算的问题
	int fib(int N) {
		if (N == 1 || N == 2) return 1;
		return fib(N - 1) + fib(N - 2);
	}
	//DPtable, 时间效率更高
	public int fibTable(int N) {
        if(N == 0) return 0;
		if(N == 1) return 1;
		int[] res = new int[N + 1];
		res[0] = 0;
		res[1] = 1;
		for(int i = 2; i < N + 1; i++) {
			res[i] = res[i - 2] + res[i - 1];
		}
		
		return res[N];
    }

    //带备忘录的斐波那契数
	public int fibMemo(int N) {
		if(N < 1) return 0;

		int[] memo = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			memo[i] = 0;
		}
		return helper(memo, N);
	}

	public int helper(int[] memo, int N) {
		if(N == 1 || N == 2) return 1;
		if(memo[N] != 0) return memo[N];//每次递归之前先去备忘录中查一下, 看看该子问题是否已经被计算过了, 如果是计算过的, 就不必再重复计算了, 直接返回结果
		memo[N] = helper(memo, N - 1) + helper(memo, N - 2);
		return memo[N];
	}
}
