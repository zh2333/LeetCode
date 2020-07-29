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
		int n = 3;
		System.out.println(fib(n));
	}
	public int fib(int N) {
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
}
