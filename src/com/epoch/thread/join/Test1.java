package com.epoch.thread.join;

/**
 * 当主线程运行join时子线程开始执行，子线程执行完成后主线程被唤醒
 * @author : Z
 * @version : 1.0
 * @Date : 2020/8/28
 */
public class Test1 {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start.");
        });

        System.out.println(Thread.currentThread().getName() + " start.");

        thread.start();

        System.out.println(Thread.currentThread().getName() + " join.");

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " waked up.");

    }
}
