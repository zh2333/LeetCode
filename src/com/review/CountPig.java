package com.review;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小明是一个数学家，他喜欢用数字给事物命名编号，他给自己编号为1，同时在2019年小明开办了一个农场，准备开始养母猪，
 * 他专门给农场的母猪用以下数列2，3，4，5，7，9，12，16，21，28，37，49，65，86，114，151...进行命名。假设农场的母猪永远不会死，
 * 小母猪出生后3年后成熟，成熟后从第三年开始每年只会生一只小母猪。第一年农场，有一只刚刚出生的小母猪和一只成熟的母猪
 * (本年不再生小猪，下一年开始生小猪)，并给他们编号为2和3。请问，第m只母猪编号为多少？其是哪一年出生的？小明还准备了1份礼物，
 * 专门颁给农场第1到m只的母猪颁奖，颁奖规则如下:选出第1到m只的母猪翻转编号(114编号翻转为411)为第k大的母猪进行颁奖，请问是第几只猪获奖？
 * 提示: f(n)=f(n-2)+f(n-3)
 */
public class CountPig {
    static class Pig {
        public int index;//出生序号
        public int born;//出生年份
        public int num;//规则序号
        public int old;//年龄

        public Pig(int index, int born, int num, int old) {
            this.index = index;
            this.born = born;
            this.num = num;
            this.old = old;
        }

        @Override
        public String toString() {
            return "Pig{" +
                    "index=" + index +
                    ", born=" + born +
                    ", num=" + num +
                    ", old=" + old +
                    '}';
        }
    }

    /**
     * 获取第n年猪的数量
     * @param n
     * @return
     */
    public static int getPigCount(int n) {
        if(n + 1 < 5)return n + 1;
        int res[] = new int[n + 1];
        res[0] = 1;
        res[1] = 2;
        res[2] = 3;
        res[3] = 4;
        for(int i=4;i<n+1;i++){
            res[i] = res[i-2] + res[i-3];//状态转移方程
        }
        return res[n];
    }

    public static int getRewardNum(List<Pig> pigList, int numM, int k){
        List<Pig> list = new ArrayList<>();
        //求第一到第m只猪，并把num反转
        for(Pig pig: pigList) if(pig.num <= numM) list.add(new Pig(pig.index,pig.born,Integer.parseInt(new StringBuilder(pig.num+"").reverse().toString()),pig.old));
        list.sort(((o1, o2) -> Integer.compare(o1.num,o2.num)));//根据num排序
        if(k<0||k>list.size())return 0;//k不合法直接返回0
        return list.get(list.size() - k).index;//返回第k大的出生序号
    }
    public static List<Pig> getPigList(int m){//得到第m只猪出生时的所有猪
        List<Pig> pigList = new ArrayList<>();
        int curYear = 2020;
        pigList.add(new Pig(1, curYear, getPigCount(1),3));//第一只成熟母猪
        pigList.add(new Pig(2, curYear, getPigCount(2),1));//第一只小母猪
        int startIndex = 3;
        int targetNum = getPigCount(m);
        while ( pigList.get(pigList.size()-1).num <= targetNum){
            List<Pig> youngPigList = new ArrayList<>();
            curYear++;
            int lastNumPig = pigList.size();
            for(int i=0;i<pigList.size();i++){
                pigList.get(i).old++;//年龄加1
                if(pigList.get(i).old>=3)//可以生小猪了
                    youngPigList.add(new Pig(startIndex++, curYear, getPigCount(lastNumPig++ + 1),1));
            }
            for (Pig p:youngPigList) pigList.add(p);
        }
        for (Pig p:pigList) System.out.println(p);
        return pigList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs[] = sc.nextLine().split(",");
        int m = Integer.parseInt(strs[0]), k = Integer.parseInt(strs[1]);
        List<Pig> pigList = getPigList(m);
        Pig targetPig = pigList.get(m-1);
        System.out.printf("%d,%d,%d\n",targetPig.num,targetPig.born,getRewardNum(pigList,targetPig.num,k));
        sc.close();
    }
}
