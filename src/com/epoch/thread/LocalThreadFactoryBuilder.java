package com.epoch.thread;

import java.util.concurrent.ThreadFactory;


/**
 * 自定义线程工厂
 *
 * @author michael
 * @version 1.0.0
 * @date 2018-01-18
 */
public class LocalThreadFactoryBuilder implements ThreadFactory {

    private int counter;
    private String name;


    public LocalThreadFactoryBuilder(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "-Thread_" + counter);
        counter++;
        return thread;
    }
}
