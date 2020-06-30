package com.epoch.demo;

import java.util.Scanner;

/**
 * @author by zjy
 * @version 1.0.0
 * @date 2020/3/12
 */
public class GodRabbit {

    public static void main(String[] args) {
        System.out.println("请输入月份：");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int rabbit = getRabbit(m);
        if(rabbit!=-1){
            System.out.println("第"+m+"个月有【"+rabbit+"】只兔子");
        }
    }

    public static int getRabbit(int month){
        int k;
        if(month<=0){
            System.out.println("请输入正确的月份！");
            return -1;
        }else if(month==1||month==2){
            return 2*1;
        }else {
             k=getRabbit(month-1)+getRabbit(month-2);
        }
        return k;
    }
}
