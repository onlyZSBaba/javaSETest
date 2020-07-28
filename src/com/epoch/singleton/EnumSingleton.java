package com.epoch.singleton;

import com.epoch.util.CloneUtils;

import java.io.*;
import java.lang.reflect.Constructor;

public enum EnumSingleton implements Serializable {

    INSTANCE;

    public EnumSingleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        System.out.println(instance == instance2);

        //反射
        /*Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        EnumSingleton enumSingleton = constructor.newInstance();
        System.out.println(instance == enumSingleton);*/

        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("EnumSingleton.obj"));
        oos.writeObject(instance);
        oos.flush();
        oos.close();
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("EnumSingleton.obj"));
        EnumSingleton enumInstance = (EnumSingleton) ois.readObject();
        ois.close();
        System.out.println(instance == enumInstance);

        //反序列化克隆
        EnumSingleton cloneInstance = CloneUtils.clone(instance);
        System.out.println(instance == cloneInstance);
    }
}
