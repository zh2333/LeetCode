package com.leetcode.p1001;

import org.junit.Test;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
	初始化 A 和 B 的元素数量分别为 m 和 n。
	示例:
	输入:
	A = [1,2,3,0,0,0], m = 3
	B = [2,5,6],       n = 3
	输出: [1,2,2,3,5,6]
	解决:
	每次都将两个数组中较大的那个数存到A数组的末尾
	A=[1,2,3,4]
	B=[5,6]
	---->
	A=[1,2,3,4,0,0]
 * @author 张恒
 *
 */

public class Solution {
	
	@Test
	public void test(){
		int[] A ={1,2,3,0,0,0};
		int[] B = {2,5,6};
		int m =3;
		int n =3;
		merge(A,3,B,3);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}
	}
    public static void merge(int[] A, int m, int[] B, int n) {
    	
    	while(m>0 && n>0){
    		A[m + n - 1] = A[m - 1] > B[n - 1] ? A[m-- - 1] : B[n-- - 1];//牛逼
    	}
    	
    	//当m==0而n!=0,A遍历完了,B没有,将B剩下的部分直接插入到A的前面即可
    	//当m!=0而n==0时,A没遍历完,B遍历完了,不用管
    	//m==0,n==0,不用管
    	//总宗上述情况,我们只需要再对第一种情况进行编码即可
    	while(n>0){
    		A[n-1] = B[n-1];
    		n--;
    	}
    }
}