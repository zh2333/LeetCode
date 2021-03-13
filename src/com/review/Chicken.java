package com.review;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Chicken {
    public static void main(String[] args) {
        int sum = getNum(3, 3, 100, new int[]{100, 200, 400});
        System.out.println(sum);
    }

    /**
     * 获得数量
     * @param n 鸡场数量
     * @param m 天数
     * @param k 每天增加的鸡的数量
     * @return
     */
    public static int getNum(int n, int m, int k, int[] a) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Integer sum = 0;
        Integer base = 0;
        for (int i = 0; i < n; i++) {//创建初始大顶堆
            heap.add(a[i]);
        }
        for (int i = 1; i < m + 1; i++) {
            Integer tmpMax = heap.poll();
            tmpMax = (tmpMax - k * i) / 2;
            heap.add(tmpMax);
        }

        for (Integer i:heap) {
            System.out.println(i);
            sum += i;
        }
        return  n * m * k + sum;
    }
}
