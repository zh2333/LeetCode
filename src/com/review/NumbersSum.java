package com.review;

import java.util.ArrayList;
import java.util.Scanner;

public class NumbersSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] arr = line.split(" ");
        int target = Integer.parseInt(arr[0]);
        int len = Integer.parseInt(arr[1]);
        int[] res = getNumsSum(target, len);
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
            if (i == res.length - 1) {
                System.out.print(res[i]);
            } else {
                System.out.print(res[i] + " \n");
            }
        }
        System.out.println(sum);
    }

    public static int[] getNumsSum(int target, int lenLimit) {
        int i = 1;
        int j = 1;
        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else if (sum == target) {
                System.out.println(i);
                System.out.println(j);
                System.out.println(sum);
                int tmpLen = j - i;
                if (ans.size()== 0 || (tmpLen >=lenLimit && tmpLen < ans.size())) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int k = i; k < j; k++) {
                        list.add(k);
                    }
                    ans = list;
                }
                sum -= i;
                i++;
            }
        }
        System.out.println(ans.size());
        int[] res = new int[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            res[k] = ans.get(k);
        }
        return res;
    }
}
