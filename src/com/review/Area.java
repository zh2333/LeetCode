package com.review;

import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = Integer.parseInt(in.nextLine().trim());
        String[] sArrays = new String[m];

        sArrays[0] = in.nextLine();
        int n = sArrays[0].length();
        char[][] map = new char[m][n];//存储m*n冰田块信息图
        map[0] = sArrays[0].toCharArray();

        for (int i = 1; i < m; i++) {
            sArrays[i] = in.nextLine();
            map[i] = sArrays[i].toCharArray();
        }

        boolean[][] isFind = new boolean[m][n];//存储对应map是否遍历

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                isFind[i][j] = false;
        }

        int count = 0;//记录冰田区域数

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (!isFind[i][j]) {
                    if (map[i][j] == '*') {
                        findMap(map, isFind, i, j, m, n);
                        count++;
                    } else
                        isFind[i][j] = true;
                }
            }
        }
        System.out.println(String.valueOf(count));
    }

    private static void findMap(char[][] map, boolean[][] isFind, int i, int j,
                                int m, int n) {

        isFind[i][j] = true;

        //左上方
        if (i > 0 && j > 0 && !isFind[i - 1][j - 1]) {
            if (map[i - 1][j - 1] == '*')
                findMap(map, isFind, i - 1, j - 1, m, n);
        }
        //上方
        if (i > 0 && !isFind[i - 1][j]) {
            if (map[i - 1][j] == '*')
                findMap(map, isFind, i - 1, j, m, n);
        }
        //右上方
        if (i > 0 && j < n - 1 && !isFind[i - 1][j + 1]) {
            if (map[i - 1][j + 1] == '*')
                findMap(map, isFind, i - 1, j + 1, m, n);
        }

        //左方
        if (j > 0 && !isFind[i][j - 1]) {
            if (map[i][j - 1] == '*')
                findMap(map, isFind, i, j - 1, m, n);
        }
        //右方
        if (j < n - 1 && !isFind[i][j + 1]) {
            if (map[i][j + 1] == '*')
                findMap(map, isFind, i, j + 1, m, n);
        }

        //右下方
        if (i < m - 1 && j > 0 && !isFind[i + 1][j - 1]) {
            if (map[i + 1][j - 1] == '*')
                findMap(map, isFind, i + 1, j - 1, m, n);
        }
        //下方
        if (i < m - 1 && !isFind[i + 1][j]) {
            if (map[i + 1][j] == '*')
                findMap(map, isFind, i + 1, j, m, n);
        }
        //右下方
        if (i < m - 1 && j < n - 1 && !isFind[i + 1][j + 1]) {
            if (map[i + 1][j + 1] == '*')
                findMap(map, isFind, i + 1, j + 1, m, n);
        }

    }
}
