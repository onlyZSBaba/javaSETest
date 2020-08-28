package com.epoch.thread.interrupted;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/8/28
 */
public class InterruptedTest extends Thread{

    @Override
    public void run() {
        while (!this.isInterrupted()){
            synchronized(this){
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " i = " + i);
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    System.out.println(Thread.currentThread().getName()+" is interrupted!.");
                    break;
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+" is dead.");
    }

    public static void main(String[] args) {
        InterruptedTest interruptedTest = new InterruptedTest();
        //interruptedTest.setPriority(10);
        interruptedTest.start();
        Thread.yield();
        synchronized (interruptedTest){
            System.out.println(Thread.currentThread().getName() + " interrupted interruptedTest.");
            interruptedTest.interrupt();
        }
    }
}
