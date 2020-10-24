package com.leetcode.utils;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.concurrent.Executors;

public class Mytest {
    private String  className;
    private String  methodname;
    private Class<?> clazz;
    private Object instance;

    /**
     * 初始化一个测试类
     * @param className 测试方法所在类(包路径)
     * @param methodname 测试方法方法名
     */
    public  Mytest(String  className, String  methodname) {
        try {
            this.className = className;
            this.methodname = methodname;
            this.clazz = Class.forName(this.className);//使用反射创建类对象
            this.instance = clazz.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 运行测试
     * @param args 测试方法参数
     */
    @Test
    public void runTest(Object... args) {
        try {
            Class<?> clazz = this.clazz;
            Object instance = this.instance;

            for (Method classMethod: clazz.getMethods()) {
                if (classMethod.getName().equals(this.methodname)) {
                    classMethod.invoke(instance,args);//执行该类中的方法
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
