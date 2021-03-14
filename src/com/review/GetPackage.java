package com.review;

import java.util.Random;

public class GetPackage {
    public static void main(String[] args) {
        int number = 10;
        double money = 50;
        RedPackage redPackage = new RedPackage(number, money);
        for (int i = 0; i < number; i++) {
            new Thread(new MoneyThread(redPackage), String.valueOf(i)).start();
        }
    }
}
class RedPackage {
    int    remainSize;
    double remainMoney;

    public RedPackage(int remainSize, double remainMoney) {
        this.remainSize = remainSize;
        this.remainMoney = remainMoney;
    }
}

class MoneyThread implements Runnable {
    private RedPackage _redPackage;

    public MoneyThread(RedPackage _redPackage) {
        this._redPackage = _redPackage;
    }

    @Override
    public void run() {
            synchronized (_redPackage) {
                if (_redPackage.remainSize == 1) {
                    _redPackage.remainSize--;
                    double money = (double) Math.round(_redPackage.remainMoney * 100) / 100;
                    System.out.println("Thread-" + Thread.currentThread().getName() + ": " + money);
                } else {
                    Random r = new Random();
                    double min = 0.01; //
                    double max = _redPackage.remainMoney / _redPackage.remainSize * 2;
                    double money = r.nextDouble() * max;
                    money = money <= min ? min : money;
                    money = Math.floor(money * 100) / 100;
                    _redPackage.remainSize--;
                    _redPackage.remainMoney -= money;
                    System.out.println("Thread-" + Thread.currentThread().getName() + ": " + money);
                }
            }
    }
}
