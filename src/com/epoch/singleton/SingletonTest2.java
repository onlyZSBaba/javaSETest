package com.epoch.singleton;

public class SingletonTest2 {

    //构造方法私有化
    private SingletonTest2(){};

    //静态内部类进行初始化
    private static class InstanceHolder{
        private static final SingletonTest2 singletonTest2=new SingletonTest2();
    }

    public static SingletonTest2 getInstance(){
        return InstanceHolder.singletonTest2;
    }
}
