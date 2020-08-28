package com.epoch.thread;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/8/11
 */
public class MyData {

    //volatile 保证变量的可见性，但不保证原子性
    volatile int number = 0;

    public void changeData(){
        this.number = 100;
    }

    //通过加锁保证原子性，但会影响并发
    public  synchronized void changeData2(){
        number++;
    }

    //使用原子类来保证原子性
    AtomicInteger atomicInteger = new AtomicInteger(number);
    public void changeData3(){
        atomicInteger.getAndIncrement();//自加
    }
}

/**
 * 线程对变量的读取和赋值操作是
 * 先将变量从主内存中拷贝一份到自己的工作内存空间，
 * 在工作内存中对变量进行操作，
 * 操作完成后再将变量的值写回主内存
 */
class Demo{

    public static void main(String[] args) {

        MyData myData = new MyData();

        //新开一个线程，命名为A
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 线程A开始执行...");
            //先休眠3秒
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //将工作内存中的值从0修改为100
            myData.changeData();
            System.out.println(Thread.currentThread().getName()+"\t 线程A中将number的值修改为100");


        },"A").start();

        while (myData.number == 0){
        }

        System.out.println(Thread.currentThread().getName()+"\t main线程已经感知到number变化，推出死循环");
    }
}

class Demo2{
    public static void main(String[] args) {

        MyData myData = new MyData();

        //创建20个线程
        for (int i = 0; i < 20; i++) {
            new Thread(()->{

                //每个线程对变量进行累加1000次操作
                for (int j = 0; j < 1000; j++) {
                    //myData.changeData2();
                    myData.changeData3();
                }

            },String.valueOf(i)).start();
        }

        //程序不关闭会继续执行main线程和GC线程，当存活的线程数大于2，说明还没有执行完，继续执行
        while (Thread.activeCount()>2){
            Thread.yield();
        }

        //System.out.println(Thread.currentThread().getName()+"最后的变量值为"+myData.number);
        System.out.println(Thread.currentThread().getName()+"最后的变量值为"+myData.atomicInteger);

    }
}

class Test{
    public static void main(String[] args) {

        int a = 31;
        System.out.println((a&1) == 0);

        HashMap<Object, Object> map = new HashMap<>(32);

        System.out.println(排列(2,4));
    }

    public static int 排列(int m,int n){
        return jic(n)/jic(n-m);
    }

    public static int jic(int i){
        int sum = 1;
        while (i > 1) {
            sum = sum * i--;
        }
        return sum;
    }
}
