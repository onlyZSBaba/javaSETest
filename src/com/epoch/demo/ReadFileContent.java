package com.epoch.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author by zjy
 * @version 1.0.0
 * @date 2020/3/17
 */
public class ReadFileContent {
    public static String txt2String(){
        File file = new File("D:/course.txt");
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s ;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }


    public static void main(String[] args) {
        //读取文件内容
        txt2String();

    }
}
