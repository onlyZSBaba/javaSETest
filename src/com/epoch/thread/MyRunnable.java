package com.epoch.thread;

import java.util.Date;

/**
 * @author by zjy
 * @version 1.0.0
 * @date 2020/4/17
 */
public class MyRunnable implements Runnable{

    private String command;

    MyRunnable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start.Time="+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" Start.Time="+new Date());
    }

    private void processCommand() {
        try {
            //线程休眠
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
