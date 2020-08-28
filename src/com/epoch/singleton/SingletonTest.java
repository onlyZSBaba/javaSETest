package com.epoch.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest {

    //使用volatile关键字 (1.保证变量的可见性;2.防止指令重排)
    private static volatile SingletonTest instance;

    //私有化构造方法
    private SingletonTest() {
        if (instance != null) {
            throw new RuntimeException("singleton实例已存在！");
        }
    }

    //双重校验锁 保证线程安全
    public static SingletonTest getInstance() {
        if (instance == null) {
            synchronized (SingletonTest.class) {
                if (instance == null) {
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SingletonTest instance = SingletonTest.getInstance();

        Constructor<SingletonTest> constructor = SingletonTest.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonTest newInstance = constructor.newInstance();

        System.out.println(newInstance == instance);


    }

}
