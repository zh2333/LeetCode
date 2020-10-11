package com.leetcode.p406;

import com.leetcode.utils.MyArray;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * 注意：
 * 总人数少于1100人。
 * 示例
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    @Test
    public void test() {
        int[][] peoples = {
                {7, 0},
                {7, 1},
                {6, 1},
                {5, 0},
                {5, 2},
                {4, 4}
        };

        peoples = reconstructQueue(peoples);
        MyArray.printTwoDimArray(peoples);
    }

    public int[][] reconstructQueue(int[][] people) {
        //优先按照身高降序排序, 如果身高一致就按照前面比此人高的人的人数升序排序;
        // 高个子先排好序总体保持顺序稳定, 矮个子再插入到k位置, 即使后面有矮个子插入进来, 总体大小顺序也没有问题
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

        List<int[]> list = new LinkedList<>();

        for (int[] person: people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[list.size()][2]);
    }
}
