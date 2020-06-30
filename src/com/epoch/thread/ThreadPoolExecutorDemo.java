package com.epoch.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author by zjy
 * @version 1.0.0
 * @date 2020/4/17
 */
public class ThreadPoolExecutorDemo {

    /**
     * 核心线程数
     */
    private static final int CORE_POOL_SIZE=5;
    /**
     * 最大线程数
     */
    private static final int MAX_POOL_SIZE=10;
    /**
     * 阻塞队列的容量
     */
    private static final int QUEUE_CAPACITY=100;
    /**
     *空闲线程超时时间，超时线程会退出
     */
    private static final Long KEEP_ALIVE_TIME=1L;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.AbortPolicy());//线程池默认拒绝策略：丢弃任务，抛出运行时异常
        for (int i = 0; i < 10; i++) {
            MyRunnable myRunnable = new MyRunnable(" " + i);
            threadPoolExecutor.execute(myRunnable);
        }
        //终止线程池
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()){
        }
        System.out.println("Finished all threads");
    }
}
