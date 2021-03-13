package com.leetcode.p815;

import java.util.*;

/**
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 *
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ...
 * 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 *
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * 示例 1：
 *
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * 示例 2：
 *
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 *

 */
public class Solution {
    public static void main(String[] args) {
        int[][] routes = {{1,2,7},{3,6,7}};
        int s = 1;
        int t = 6;
        System.out.println(numBusesToDestination(routes, s, t));
    }
    /**
     * 记录一个站点会有哪些公交车会经过
     * @param routes
     * @return
     */
    public static Map<Integer, Set<Integer>> buildMap(int[][] routes) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] path = routes[i];
            for (int j = 0; j < path.length; j++) {
                if (map.containsKey(path[j])) {
                    Set<Integer> list = map.get(path[j]);
                    list.add(i);
                    map.put(path[j], list);
                } else {
                    Set<Integer> list = new HashSet<>();
                    list.add(i);
                    map.put(path[j], list);
                }
            }
        }
        return map;
    }

    /**
     * @param routes
     * @param S
     * @param T
     * @return 这个站 几条线经过
     */
    public static int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        Map<Integer, Set<Integer>> map = buildMap(routes);
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(map.get(S));// 取出经过源站的车有哪些
        Set<Integer> set = new HashSet<>();
        int count = 1;
        for (Integer integer : map.get(S)) {//将经过源站的所有车存起来
            set.add(integer);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int bus = queue.poll();//取出一个经过源站的车
                for (int k : routes[bus]) {// 遍历该车经过的所有站点
                    if (k == T) {
                        return count;
                    }
                    for (int busindex : map.get(k)) {//遍历该站点经过的车， 如果集合中没有该车加入集合
                        if (set.contains(busindex)) {
                            continue;
                        }
                        queue.add(busindex);
                        set.add(busindex);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
