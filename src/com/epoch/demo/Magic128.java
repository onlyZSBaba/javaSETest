package com.epoch.demo;

import java.util.List;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/7/1
 */
public class Magic128 {

    public static void main(String[] args) {

        Integer a = 40;

        Integer b = 40;

        Integer c = 128;

        Integer d = 128;

        /*System.out.println(a==b);

        System.out.println(c==d);

        int num1 = 1;

        int num2 = 2;

        System.out.println("交换之前: num1 = "+num1+"; num2 = "+num2);

        num1 = num1^num2;

        num2 = num1^num2;

        num1 = num1^num2;

        System.out.println("交换之后: num1 = "+num1+"; num2 = "+num2);

        int intNum = 2147483647+1;

        byte bt =127;

        System.out.println(intNum);
        System.out.println(bt+1);*/


        stringTest();
    }


    public static void stringTest(){

        String s = "abc";

        String s1 = new String("abc");

        String s2 = new String("abc").intern();

        String s3 = new String("def").intern();

        System.out.println(s==s1);
        System.out.println(s==s2);
        System.out.println(s1==s2);

        System.out.println(s3);
    }

}
