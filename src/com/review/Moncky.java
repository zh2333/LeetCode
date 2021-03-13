package com.review;

import java.util.Arrays;
import java.util.HashMap;

public class Moncky {
    public static void main(String[] args) {
        int[] nums = {10, 4, 5, 12, 8};
        int num = getPeach(nums);
        System.out.println(num);
    }

    public static int getPeach (int[] peachs) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < peachs.length; i++) {
            map.put(peachs[i], i);
        }
        Arrays.sort(peachs);
        int num = 0;
        int tmp = 1;
        for (int i = 1;i < peachs.length; i++) {
            if (map.get(peachs[i]) > map.get(peachs[i - 1])) {
                tmp++;
            } else {
                if (tmp > num) {
                    num = tmp;
                }
                tmp = 0;
            }
        }
        return num;
    }
}
