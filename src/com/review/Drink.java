package com.review;

import java.util.Scanner;

public class Drink {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int price;
        price = Integer.parseInt(in.nextLine().trim());

        int cap;
        cap = Integer.parseInt(in.nextLine().trim());

        int emptyBottle;
        emptyBottle = Integer.parseInt(in.nextLine().trim());

        int money;
        money = Integer.parseInt(in.nextLine().trim());

        res = maxMount(price, cap, emptyBottle, money);
        System.out.println(String.valueOf(res));
    }

    private static int maxMount(int price, int cap, int emptyBottle, int money) {
        int count = 0;
        int num_cap = 0;
        int num_epBottle = 0;
        if (money < price) {
            return 0;
        }
        count = money / price;
        num_cap = count;
        num_epBottle = count;
        int temp;//记录一轮兑换瓶数

        while (num_cap >= cap || num_epBottle >= emptyBottle) {
            temp = num_cap / cap;
            num_cap = num_cap % cap;
            temp = temp + num_epBottle / emptyBottle;
            num_epBottle = num_epBottle % emptyBottle;
            count = count + temp;
            num_cap = num_cap + temp;
            num_epBottle = num_epBottle + temp;
            temp = 0;
        }

        return count;
    }
}
