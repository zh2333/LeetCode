package com.leetcode.p452;


import com.leetcode.utils.MyArray;
import com.leetcode.utils.Mytest;
import org.junit.Test;

import java.util.Arrays;

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 *
 *  
 * 示例 1：
 *
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * 示例 2：
 *
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 示例 3：
 *
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 示例 4：
 *
 * 输入：points = [[1,2]]
 * 输出：1
 * 示例 5：
 *
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 0 <= points.length <= 104
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    @Test
    public void test() {
        String str = "[[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]";
        int[][] arr = MyArray.convertStrToArray(str);
        int res = findMinArrowShots(arr);
        System.out.println(res);

    }
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len == 0 || len == 1) {
            return len;
        }
        Arrays.sort(points, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] < o2[1] ? -1 : 1;
            }
            return o1[0] < o2[0] ? -1 : 1;
        }));
        MyArray.printTwoDimArray(points);
        int[] shootArea = points[0];
        int shoots = 1;
        for (int i = 1; i < len ; i++) {
            int[] intersection = getIntersection(shootArea, points[i]);
            if (intersection == null) {//如果射击区间和新区间的交集为空, 意味着需要额外的一次射击, 并且要更新射击区间为新区间
                shootArea = points[i];
                shoots++;
            } else {//射击区间和新区间有交集, 则不需要额外的射击次数, 射击区间更新为射击区间和新区间的交集, 射击次数不变
                shootArea = intersection;
            }
        }
        return shoots;
    }

    /**
     * 获得两个数组的交集.传入的数组, arr1的左端点小于arr2的左端点
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] getIntersection(int[] arr1, int[] arr2) {
        int[] intersection = new int[2];
        if (arr1[1] >= arr2[0] && arr1[1] < arr2[1]) {
            intersection[0] = arr2[0];
            intersection[1] = arr1[1];
            return  intersection;
        } else if (arr1[1] >= arr2[1]){
            intersection[0] = arr2[0];
            intersection[1] = arr2[1];
            return intersection;
        }
        return null;
    }
}
