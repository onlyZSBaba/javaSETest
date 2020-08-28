package com.epoch.thread.producer_and_customer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/8/28
 */
public class BlockQueueTest {

    /**
     * 生产者
     */
    static class Producer{

        private BlockingQueue<Integer> blockingQueue;

        Producer(BlockingQueue<Integer> blockingQueue){
            this.blockingQueue = blockingQueue;
        }

        void produce(final int count){

            new Thread(()->{
                for (int i = 0; i < count; i++) {
                    try {
                        Thread.sleep(100);
                        blockingQueue.put(1);
                        System.out.println(Thread.currentThread().getName()+" 生产了 1 条消息，当前库存为 "+blockingQueue.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            },"producerThread").start();
        }

    }

    /**
     * 消费者 consumer
     */
    static class Customer{
        private BlockingQueue<Integer> blockingQueue;

        Customer(BlockingQueue<Integer> blockingQueue){
            this.blockingQueue = blockingQueue;
        }

        void consume(final int count){

            new Thread(()->{
                for (int i = 0; i < count; i++) {
                    try {
                        Thread.sleep(200);
                        blockingQueue.take();
                        System.out.println(Thread.currentThread().getName()+" 消费了 1 条数据，当前库存为 "+blockingQueue.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            },"customerThread").start();
        }
    }

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        Producer producer = new Producer(queue);
        Customer customer = new Customer(queue);
        producer.produce(10);
        customer.consume(10);
    }
}
