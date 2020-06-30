package com.epoch.demo;


/**
 * @author by zjy
 * @version 1.0.0
 * @date 2020/4/7
 */
public  class HashMapTest {

    private static  HashMapTest hashMap=null;

    private HashMapTest() {}

    private synchronized static HashMapTest getInstance(){
        if(null==hashMap){
            hashMap=new HashMapTest();
        }
         return hashMap;
    }

    public static void main(String[] args) {

        /*HashMapTest instance = HashMapTest.getInstance();
        System.out.println(instance.getClass().getName());*/

        new Thread(()-> {
            try {
                Thread.sleep(1000);
                HashMapTest instance = HashMapTest.getInstance();
                System.out.println(instance.getClass().getName());
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程2").start();
    }
}
