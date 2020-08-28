package com.epoch.thread.producer_and_customer;

import java.util.ArrayList;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/8/28
 */
public class ArrayListTest {

    private final static int MAX_SIZE = 10;
    private static ArrayList<Integer> arrayList;

    public static void main(String[] args) {
        arrayList = new ArrayList<>(MAX_SIZE);
        ArrayListTest arrayListTest = new ArrayListTest();
        arrayListTest.producer(arrayList);
        arrayListTest.consumer(arrayList);
    }

    /**
     * 生产者
     * @param arrayList
     */
    void producer(ArrayList<Integer> arrayList){
        new Thread(()->{
            while (true){
                //设置生产速率 200毫秒生产一个
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //第一步拿到锁
                synchronized (arrayList){
                    //判断库存是个否已经满了
                    while (arrayList.size() >= MAX_SIZE){
                        try {
                            arrayList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    arrayList.add(1);
                    //通知消费者消费
                    arrayList.notifyAll();
                    System.out.println(Thread.currentThread().getName()+" 生产了 1 条消息，当前库存为 "+arrayList.size());
                }
            }
        },"producerThread").start();
    }

    /**
     * 消费者
     * @param arrayList
     */
    void consumer(ArrayList<Integer> arrayList){

        new Thread(()->{
            while (true){
                //设置消费者速率  300ms消费一个
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //获取锁
                synchronized (arrayList){
                    //判断是否还有库存
                    while (arrayList.size() == 0){
                        //消费者停止消费
                        try {
                            arrayList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        //
                    }
                    //消费一条记录
                    arrayList.remove(0);
                    //通知生产者生产
                    arrayList.notifyAll();
                    System.out.println(Thread.currentThread().getName()+" 生产者生产了 1 条消息，当前库存为 "+arrayList.size());
                }
            }

        },"consumer").start();
    }
}
