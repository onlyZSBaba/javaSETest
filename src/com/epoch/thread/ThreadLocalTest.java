package com.epoch.thread;

/**
 * @author by zjy
 * @version 1.0.0
 * @date 2020/4/21
 */
public class ThreadLocalTest extends Thread implements Runnable{
    private static ThreadLocal<String> threadLocal= new ThreadLocal<>();

    public static void main(String[] args) {
        System.out.println("开启主线程");
        System.out.println("将主线程的本地线程设置为123");
        threadLocal.set("123");

        /*new Thread(()->{
            System.out.println("新开线程并将本地线程设置为321");
            threadLocal.set("321");
            System.out.println("获取新开线程本地线程的值");
            System.out.println(threadLocal.get());
            //使用完成后移除，防止内存泄露
            threadLocal.remove();
        }).start();*/

        Thread thread= new ThreadLocalTest();
        thread.start();

        System.out.println("获取主线程的本地线程的值");
        System.out.println(threadLocal.get());
        //使用完成后移除，防止内存泄露
        threadLocal.remove();

    }

    @Override
    public void run() {
        System.out.println("新开线程并将本地线程设置为321");
        threadLocal.set("321");
        System.out.println("获取新开线程本地线程的值");
        System.out.println(threadLocal.get());
        //使用完成后移除，防止内存泄露
        threadLocal.remove();
    }
}
