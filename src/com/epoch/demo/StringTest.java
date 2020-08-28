package com.epoch.demo;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author by zjy
 * @version 1.0.0
 * @date 2020/1/13
 */
public class StringTest {

    public static void method(String str,String str2){
        int index;
        if(str.contains(str2)){
            index=str.indexOf(str2)+1;
            System.out.println(str2+"是"+str+"的子串，起始位置是"+index);
        }else {
            System.out.println(str2+"不是"+str+"的子串");
        }
    }

    public static void breakString(String str){

        int number=0;
        int bigCount=0;
        int smallCount=0;
        int other=0;
        int chinese=0;

        String reg="^[\u4e00-\u9fa5]{1}$";//正则

        for (int i = 0, len=str.length();i < len; i++) {
            char c = str.charAt(i);

            String s=Character.toString(c);

            if(c>='A'&&c<='Z'){
                bigCount++;
            }else if(c>='a'&&c<='z'){
                smallCount++;
            }else if(c>='0'&&c<='9'){
                number++;
            }else if(s.matches(reg)){
                chinese++;
            }else {
                other++;
            }
        }

        System.out.println("大写字母个数："+bigCount);
        System.out.println("小写字母个数："+smallCount);
        System.out.println("大数字个数："+number);
        System.out.println("汉字个数："+chinese);
        System.out.println("其他个数："+other);
    }


    public static void main(String[] args) {

        /*String str="hello,world";
        String str2="hello";
        method(str,str2);

        breakString("123ASDas你好  ￥￥ ");*/

        String s ="helloWorld";

        int i = method2(s);
        System.out.println("第一个重复的字符索引是："+i);

        String result=method3(s);
        System.out.println(result);

    }

    private static String method3(String s) {

        HashSet<String> strSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            strSet.add(String.valueOf(c));
        }
        StringBuilder sBuilder = new StringBuilder(s);
        for (String s1 : strSet) {
            sBuilder.append(s1);
        }
        s = sBuilder.toString();
        return s;
    }

    private static int method2(String s) {

        int index=-1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(s.indexOf(c,i+1)!=-1){
                index=i;
                break;
            }
        }
        return index;
    }
}
