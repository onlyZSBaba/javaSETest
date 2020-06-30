package com.epoch.demo;

import java.util.ArrayList;

/**
 * @author by zjy
 * @version 1.0.0
 * @date 2020/5/7
 */
public class ProducerAndCustomerMode {

    static int MAX_SIZE=10;
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        list= new ArrayList<>(MAX_SIZE);
        new Thread(new Producer()).start();
        new Thread(new Customer()).start();
    }

    /**
     * 生产者
     */
    private static class Producer implements Runnable{
        @Override
        public void run() {
            while (true){
                //生产效率：200ms/个
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //第一步拿到锁
                synchronized (list){
                    //判断是否库存满了
                    while (list.size()>=MAX_SIZE){
                        //满了则等待消费者消费
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //否则生产一个
                    list.add(1);
                    System.out.println("生产了一个，现在库存为:"+list.size()+"个");
                    //唤醒消费者消费
                    list.notifyAll();
                }
            }
        }
    }

    /**
     * 消费者
     */
    private static class Customer implements Runnable{
        @Override
        public void run() {
            while (true){
                //消费效率：300ms/个
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //第一步拿到锁
                synchronized (list){
                    //判断库存是否为空
                    while (list.size()==0){
                        //等待生产者生产
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //否则消费一个
                    list.remove(0);
                    System.out.println("消费了一个，现在库存为："+list.size()+"个");
                    //唤醒生产者生产
                    list.notifyAll();
                }
            }
        }
    }
}
