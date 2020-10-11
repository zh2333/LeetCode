package com.leetcode.p56;

import java.util.ArrayList;

import com.leetcode.utils.MyArray;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。

	示例 1:
	
	输入: [[1,3],[2,6],[8,10],[15,18]]
	输出: [[1,6],[8,10],[15,18]]
	解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
	示例 2:
	
	输入: [[1,4],[4,5]]
	输出: [[1,5]]
	解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/merge-intervals
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张恒
 *
 */
public class Solution {
	public static int[][] merge(int[][] intervals) {
		ArrayList<int[]> res = new ArrayList<>();
		boolean status;
		boolean flag = false;
		for(int[] arr : intervals) {
			res.add(arr);
		}
		
		int i = 0;
		int j = 1;
		while(i < res.size()) {
			while(j < res.size()) {
				if(flag && res.size() > 1) {
					i = 0;
					j = 1;
				}
				int[] arr1 =  res.get(i);
				int[] arr2 = res.get(j);
				if(arr1[0] < arr2[0]) {
					status = isOverlap(arr1, arr2);
					if(status) {
						int[] tmp = new int[2];
						tmp[0] = arr1[0];
						tmp[1] = arr1[1] > arr2[1] ? arr1[1] : arr2[1];
						res.remove(i);
						res.remove(j-1);
						res.add(tmp);
						flag = true;
					} else {
						j++;
						flag = false;
					}
				} else {
					status = isOverlap(arr2, arr1);
					if(status) {
						int[] tmp = new int[2];
						tmp[0] = arr2[0];
						tmp[1] = arr1[1] > arr2[1] ? arr1[1] : arr2[1];
						res.remove(i);
						res.remove(j-1);
						res.add(tmp);
						flag = true;
					} else {
						j++;
						flag = false;
					}
				}
				
			}
			if(flag && res.size() > 1) {
				i = 0;
				j = 1;
			}else {
				i++;
				j = i + 1;
			}
		}
		
		int[][] ans = new int[res.size()][2];
		for(int i1 = 0; i1 < res.size();i1++) {
			ans[i1] = res.get(i1);
		}
		return ans;
		
    }
	
	/**
	 * arr1[0] < arr2[0]
	 * @param arr1 左边的数组
	 * @param arr2 右边的数组
	 * @return
	 */
	public static boolean isOverlap(int[] arr1, int[] arr2){
		if(arr1[1] < arr2[0]) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] example = {{2,2},{2,3},{4,6},{5,6},{1,2},{5,6},{1,3},{3,3}};
		int[][] res = merge(example);
		MyArray.printTwoDimArray(res);
		
		
	}
	
	
}
