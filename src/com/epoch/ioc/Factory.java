package com.epoch.ioc;

/**
 * @author by zjy
 * @version 1.0.0
 * @date 2020/4/20
 */
class Factory {
    static Fruit getInstance(String className){
        Fruit fruit=null;
        try {
            fruit= (Fruit) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit;
    }
}
