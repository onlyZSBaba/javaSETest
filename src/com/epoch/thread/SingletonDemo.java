package com.epoch.thread;

/**
 * @author by zjy
 * @version 1.0.0
 * @date 2020/5/18
 */
public class SingletonDemo {

    private static volatile SingletonDemo singletonDemo;

    //构造函数私有化
    private SingletonDemo(){
        if(singletonDemo!=null){
            //防止破坏单例
            throw new RuntimeException("singleton实例已存在!请以getInstance()方法获取!");
        }
    }

    /**
     * 双重校验
     * @return
     */
    public static SingletonDemo getInstance(){
        if(singletonDemo==null){
            synchronized (SingletonDemo.class){
                if(singletonDemo==null){
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

    private static class InstanceHolder{
        private final static SingletonDemo instance=new SingletonDemo();
    }

    /**
     * 静态内部类
     * @return
     */
    public static SingletonDemo getInstance2(){
        return InstanceHolder.instance;
    }

    private enum Singleton{

        INSTANCE;

        private final SingletonDemo instance;

        Singleton(){
            instance=new SingletonDemo();
        }

        private  SingletonDemo getInstance(){
            return instance;
        }
    }

    /**
     * 枚举实现
     * @return
     */
    public static SingletonDemo getInstance3(){
        return Singleton.INSTANCE.getInstance();
    }

}

 class SingletonTest{
     public static void main(String[] args) {

         /*SingletonDemo instance = SingletonDemo.getInstance();
         System.out.println(instance.toString());

         SingletonDemo instance2 = SingletonDemo.getInstance2();
         System.out.println(instance2.toString());

         SingletonDemo instance3 = SingletonDemo.getInstance3();
         System.out.println(instance3.toString());
         */

         //轻灵之靴 绿叉 分裂弓 火炮 电刀 幽梦之灵
         double spend=345+60+345*0.14+345*0.09+345*0.07*2+345*0.4;
         System.out.println("spend="+spend);
     }
}
