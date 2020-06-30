package com.epoch.singleton;

public class SingletonTest {

    //使用volatile关键字
    private static volatile SingletonTest singletonTest;

    //私有化构造方法
    private SingletonTest(){
        if(singletonTest!=null){
            throw new RuntimeException("singleton实例已存在！");
        }
    }

    //双重校验锁 保证线程安全
    public static SingletonTest getInstance(){
        if(singletonTest==null){
            synchronized (SingletonTest.class){
                if(singletonTest==null){
                    singletonTest=new SingletonTest();
                }
            }
        }
        return singletonTest;
    }
}
