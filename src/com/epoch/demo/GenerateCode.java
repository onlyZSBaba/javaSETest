package com.epoch.demo;

import java.util.Random;

public class GenerateCode{

    /**
     * 生成指定位数的随机数
     * @param len 随机数的位数
     * @return 返回随机数
     */
    public static String generateCode(int len){
        len = Math.min(len, 8);
        int min = Double.valueOf(Math.pow(10, len - 1)).intValue();
        int num = new Random().nextInt( Double.valueOf(Math.pow(10, len + 1)).intValue() - 1) + min;
        return String.valueOf(num).substring(0,len);
    }

    public static void main(String[] args) {
        String s = generateCode(6);
        System.out.println(s);
    }
}
