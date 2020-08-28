package com.epoch.thread.join;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/8/19
 */
public class JoinDemo {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            JoinThread joinThread = new JoinThread(currentThread);
            joinThread.start();
            currentThread = joinThread;
        }
    }
    static class JoinThread extends Thread{

        private Thread thread;

        JoinThread(Thread thread){
            this.thread = thread;
        }
        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(thread.getName()+" terminated");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

