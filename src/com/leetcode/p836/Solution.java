package com.leetcode.p836;

/**
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
	如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
	给出两个矩形，判断它们是否重叠并返回结果。
	示例 1：
	
	输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
	输出：true
	示例 2：
	
	输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
	输出：false
 * @author 张恒
 * 解决:有2种情况是不会相交的:
 *  右上x<=左下x
 *  右上y<=左下y
 *  在矩阵表示中,为4种情况
 *  rec1[0]--左下x >= rec2[2]--右上x
 *  rec2[0]--左下x >= rec1[2]--右上x
 *  rec1[1]--左下y >= rec2[3]--右上y
 *  rec2[1]--左下y >= rec2[3]--右上y
 */
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    	return !(rec1[0]>=rec2[2] || rec2[0]>=rec1[2] || rec1[1]>=rec2[3] || rec2[1]>=rec1[3] );
    }
}
