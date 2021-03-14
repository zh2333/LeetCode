package com.review;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo {
    public static void main(String[] args) {
        int totalNumber = 100;
        AtomicInteger value = new AtomicInteger(0);
        int threadNum = 10;

        for (int i = 0; i < threadNum; i++) {
            PrintThread printThread = new PrintThread(totalNumber, value, threadNum);
            new Thread(printThread, String.valueOf(i)).start();
        }
    }
}

class PrintThread implements Runnable {
    private  int totalNumber;
    private  AtomicInteger value;
    private  int threadNum;

    public PrintThread(int totalNumber, AtomicInteger value, int threadNum) {
        this.totalNumber = totalNumber;
        this.value = value;
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        try {
            while (value.get() <= totalNumber) {
                synchronized (value) {
                    String name = Thread.currentThread().getName();
                    int taskThreadNum = Integer.parseInt(name);
                    if (value.get() == taskThreadNum || value.get() % threadNum == taskThreadNum) {
                        System.out.println("Thread-" + name + ": " + value);
                        value.getAndIncrement();
                        value.notifyAll();
                    } else {
                        value.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

