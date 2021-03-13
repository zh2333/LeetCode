package com.review;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Walk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();
        String[] lineArgs = firstLine.split(" ");
        int lines = Integer.parseInt(lineArgs[0]);
        int rows = Integer.parseInt(lineArgs[1]);
        int walks = Integer.parseInt(lineArgs[2]);
        String[][] matrix = new String[lines][rows];
        int[] start = new int[2];
        for (int i = 0; i < lines; i++) {
            String tmp = sc.nextLine();
            String[] items = tmp.split(" ");
            for (int j = 0; j < rows; j++) {
                String item = items[j];
                if (!("\n" . equals(item))) {
                    matrix[i][j] = item;
                    if ("@" . equals(item)) {
                        start[0] = i;
                        start[0] = j;
                    }
                }
            }
        }

        ArrayList<String> forwards = new ArrayList<>();
        int index = 0;
        while (index < walks) {
            String tmp = sc.next();
            forwards.add(tmp);
            index++;
        }
        int[] res = getEndPos(start, matrix,forwards);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }

    public static int[] getEndPos(int[] start, String[][] matrix, List<String> forwards) {
        int startX = start[0];
        int startY = start[1];
        for (String forward : forwards) {
            if ("EAST".equals(forward)) {
                while (startY < matrix[0].length - 1 && !(("#").equals(matrix[startX][startY]))) {
                    startY++;
                }
                if ((("#").equals(matrix[startX][startY]))) {//回退一步
                    startY--;
                }
            }
            if ("WEST".equals(forward)) {
                while (startY > 0 && !(("#").equals(matrix[startX][startY]))) {
                    startY--;
                }
                if ((("#").equals(matrix[startX][startY]))) {//回退一步
                    startY++;
                }
            }
            if ("SOUTH".equals(forward)) {
                while (startX < matrix.length - 1 && !(("#").equals(matrix[startX][startY]))) {
                    startX++;
                }
                if ((("#").equals(matrix[startX][startY]))) {//回退一步
                    startX--;
                }
            }
            if ("NORTH".equals(forward)) {
                while (startX > 0 && !(("#").equals(matrix[startX][startY]))) {
                    startX--;
                }
                if ((("#").equals(matrix[startX][startY]))) {//回退一步
                    startX++;
                }
            }
        }
        return new int[]{startX + 1, startY + 1};
    }
}
