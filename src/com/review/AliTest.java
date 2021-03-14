package com.review;


import java.util.concurrent.atomic.AtomicInteger;


class OutTask extends Thread {
    private final NumOut numOut;
    private final int mark;
    private final int threadCount;

    OutTask(NumOut numOut, int mark, int maxInt) {
        this.mark = mark;
        this.numOut = numOut;
        this.threadCount = maxInt;
    }

    @Override
    public void run() {
        /* 没有输出完全部数字时 保持自旋 */
        /* 通过与操作获取累计数值与最大输出数值比较  */
        while ((this.numOut.state.get() & NumOut.LOW) <= NumOut.MAXNUM) {
            /* 通过与操作获取高16位数值 即 当前应该执行的线程编号 ，并且二次判断数值是否全部输出完毕 */
            if ((this.numOut.state.get() & NumOut.HEIGHT) >> NumOut.NOWMARK_OFFSET == mark
                    && (this.numOut.state.get() & NumOut.LOW) <= NumOut.MAXNUM) {

                if (threadCount - 1 == mark) {
                    /* 当线程编号达到最后一个时 另做处理 */
                    /* 获取当前累计的数值 并输出 */
                    int next = (this.numOut.state.get() & NumOut.LOW);
                    System.out.println("thread" + mark + "：" + (next));
                    /* 计算下一数值 低16位+1 高十六位清0 */
                    this.numOut.state.set(next + 1);
                } else {
                    /* 获取当前累计的数值 并输出 */
                    System.out.println("thread" + mark + "：" + ((this.numOut.state.get() & NumOut.LOW)));
                    /* 计算下一数值 高低16位各+1 */
                    this.numOut.state.addAndGet(1 + (1 << NumOut.NOWMARK_OFFSET));
                }
            }
        }
    }
}

class NumOut {
    public static final int LOW = 0x0000FFFF;
    public static final int HEIGHT = 0xFFFF0000;
    /* 最大数值 */
    public static final int MAXNUM = 100;
    /* 线程号偏移量 */
    public static final int NOWMARK_OFFSET = 16;
    /* 状态值 */
    final AtomicInteger state = new AtomicInteger(0);
    /* 线程数 */
    final int count;

    public NumOut(int count) {
        // TODO Auto-generated constructor stub
        this.count = count;
    }

    public void outPut() {
        /* 创建任务并启动  */
        for (int i = 0; i < count; i++) {
            Thread a = new OutTask(this, i, count);
            a.start();
        }
    }
}

public class AliTest {
    public static void main(String[] args) {
        NumOut numOut = new NumOut(5);
        numOut.outPut();
    }
}
