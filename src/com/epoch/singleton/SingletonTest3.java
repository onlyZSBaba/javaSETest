package com.epoch.singleton;

public class SingletonTest3 {

    //构造方法私有化
    private SingletonTest3(){};

    private enum SingletonEnum{

        //枚举类型
        INSTANCE;

        private final SingletonTest3 instance;

        SingletonEnum(){
            instance=new SingletonTest3();
        }

        public  SingletonTest3 getInstance(){
            return instance;
        }
    }

    public static SingletonTest3 getInstance(){
        return SingletonEnum.INSTANCE.getInstance();
    }

    public static void main(String[] args) {

        SingletonTest3 instance = getInstance();
        System.out.println(instance);
    }
}
