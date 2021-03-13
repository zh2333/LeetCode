package com.review;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class WordFilter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<String, String> map = new ConcurrentHashMap<>();
        String pattern = sc.nextLine();
        System.out.println(judge(str,pattern));
    }
    //动态规划
    public static int judge(String str,String pattern){
        int[][] matchsArr = new int[str.length()+1][pattern.length()+1];
        matchsArr[str.length()][pattern.length()]=1;
        for(int i=pattern.length()-1;i>=0;i--){
            if(pattern.charAt(i)!='*') {
                break;
            }
            else {
                matchsArr[str.length()][i] = 1;
            }
        }
        for(int i=str.length()-1;i>=0;i--){
            for(int j=pattern.length()-1;j>=0;j--){
                if(pattern.charAt(j)=='?' || str.charAt(i)==pattern.charAt(j)) {
                    matchsArr[i][j] = matchsArr[i + 1][j + 1];
                }
                else if(pattern.charAt(j)=='*') {
                    matchsArr[i][j] = matchsArr[i + 1][j] | matchsArr[i][j + 1];
                }
                else {
                    matchsArr[i][j] = 0;
                }
            }
        }
        return matchsArr[0][0];
    }
}
