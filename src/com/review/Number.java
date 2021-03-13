package com.review;

import static java.lang.Integer.min;

public class Number {
    public static void main(String[] args) {
        int index = 10;
        int[] arr = {3, 4, 6, 9, 10, 16, 17, 19, 21};
        System.out.println(getNumber(arr, index));
    }

    public static int getNumber(int[] arr, int k) {
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int gap = arr[i + 1] - arr[i] - 1;
            if (k - gap <= 0) {
                res = arr[i] + min(gap, k);
                return res;
            } else {
                k -= gap;
            }
        }
        return 0;
    }
}
