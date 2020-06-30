package com.epoch.ioc;

/**
 * @author by zjy
 * @version 1.0.0
 * @date 2020/4/20
 */
public class Client {
    public static void main(String[] args) {
        Fruit f = Factory.getInstance("com.epoch.ioc.Orange");
        if(null!=f){
            f.eat();
        }
    }
}
