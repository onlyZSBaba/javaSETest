package com.epoch.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest3 {

    //构造方法私有化
    private SingletonTest3() {
    }

    private enum SingletonEnum {

        //枚举类型
        INSTANCE;

        private final SingletonTest3 instance;

        SingletonEnum() {
            instance = new SingletonTest3();
        }

        public SingletonTest3 getInstance() {
            return instance;
        }
    }

    public static SingletonTest3 getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SingletonTest3 instance = getInstance();
        SingletonTest3 instance2 = getInstance();
        System.out.println(instance == instance2);

        Constructor<SingletonTest3> constructor = SingletonTest3.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonTest3 newInstance = constructor.newInstance();
        System.out.println(instance == newInstance);

    }
}
