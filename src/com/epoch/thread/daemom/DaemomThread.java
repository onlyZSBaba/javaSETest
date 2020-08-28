package com.epoch.thread.daemom;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/8/19
 */
public class DaemomThread {
    public static void main(String[] args) {

        Thread daemonThread = new Thread(() -> {
            while (true){
                System.out.println("i an alive");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //守护线程的finally块不可靠，用户线程执行结束后守护线程也会自动退出
                    System.out.println("finally block");
                }
            }
        });

        //先设置为守护线程再执行start(),否则会抛出 java.lang.IllegalThreadStateException 异常
        daemonThread.setDaemon(true);
        daemonThread.start();
        //main线程休眠800毫秒让出时间片，保证守护线程再次执行
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
