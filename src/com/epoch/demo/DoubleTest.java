package com.epoch.demo;

/**
 * @author by zjy
 * @version 1.0.0
 * @date 2020/4/14
 */
public class DoubleTest {
    public static void main(String[] args) {
        double a,b;
        a=0.1;
        b=0.2;
        double c=a+b;
        String str=String.valueOf(c);
        String[] strings = str.split("\\.");

        String substr = str.substring(str.indexOf(".")+1);
        System.out.println(a+"+"+b+"="+c);
        System.out.println("小数一共有"+substr.length()+"位");
        System.out.println("小数一共有"+strings[1].length()+"位");
    }
}
