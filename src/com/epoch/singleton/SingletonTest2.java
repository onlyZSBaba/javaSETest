package com.epoch.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest2 implements Serializable {

    //构造方法私有化
    private SingletonTest2() {
    }

    //静态内部类进行初始化
    private static class InstanceHolder {
        private static final SingletonTest2 instance = new SingletonTest2();
    }

    public static SingletonTest2 getInstance() {
        return InstanceHolder.instance;
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, IOException, ClassNotFoundException {
        SingletonTest2 instance1 = getInstance();
        SingletonTest2 instance2 = getInstance();
        System.out.println(instance1 == instance2);

        Constructor<SingletonTest2> constructor = SingletonTest2.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonTest2 instance3 = constructor.newInstance();
        System.out.println("反射");
        System.out.println(instance1 == instance3);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SingletonTest.obj"));
        oos.writeObject(instance1);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SingletonTest.obj"));
        SingletonTest2 serInstance = (SingletonTest2) ois.readObject();
        ois.close();

        System.out.println("序列化");
        System.out.println(instance1 == serInstance);
    }
}
