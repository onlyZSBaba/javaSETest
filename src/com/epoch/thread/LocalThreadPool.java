package com.epoch.thread;

import java.util.concurrent.*;

/**
 * 本地任务处理线程池
 *
 * @author michael
 * @version 1.0.0
 * @date 2018-01-18
 */
public class LocalThreadPool {

    private ExecutorService executorService;

    public LocalThreadPool(){

        ThreadFactory customThreadFactoryBuilder = new LocalThreadFactoryBuilder("localThread");

        executorService = new ThreadPoolExecutor(8, 20,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), customThreadFactoryBuilder, new ThreadPoolExecutor.AbortPolicy());
    }

    public ExecutorService getPool(){
        return executorService;
    }
}
