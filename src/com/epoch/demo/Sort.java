package com.epoch.demo;

/**
 * @author by zjy
 * @version 1.0.0
 * @date 2020/5/7
 */
public class Sort {

    static int[] selectSort(int[] arr){
        int n=arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min=i;
            for (int j = i+1; j <n ; j++) {
                if(arr[min]>arr[j])
                    min=j;
            }
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
        return arr;
    }

    static int[] BubbleSort(int[] arr){
        int n=arr.length;
        boolean flag=false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j + 1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    flag=true;
                }
            }
            if (!flag){
                return arr;
            }
        }
        return arr;
    }
}
