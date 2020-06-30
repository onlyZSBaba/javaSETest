package com.epoch.demo;

/**
 * @author by zjy
 * @version 1.0.0
 * @date 2020/1/13
 */
public class RK {

    public static int robinKarp(String str,String pattern){
        int m=str.length();
        int n=pattern.length();
        int patternHash = hashcode(pattern);
        int strHash = hashcode(str.substring(0, n));
        for (int i = 0; i < (m - n + 1); i++) {
            if(patternHash==strHash&&compare(i,str,pattern)){
                return i+1;
            }
            if(i<m-n){
                strHash=nextHash(str,strHash,i,n);
            }
        }
        return -1;
    }

    private static int nextHash(String str, int strHash, int i, int n) {
        strHash-=str.charAt(i)-('a'-1);
        strHash+=str.charAt(i+n)-('a'-1);
        return strHash;
    }

    /**
     * 比较
     * @param str
     * @param pattern
     * @return
     */
    private static boolean compare(int i,String str, String pattern) {
        String subStr=str.substring(i,i+pattern.length());
        return pattern.equals(subStr);
    }

    /**
     * 自定义哈希码
     * @param str 字符串
     * @return 自定义哈希码
     */
    private static int hashcode(String str){
        int hashcode=0;
        for (int i = 0; i < str.length(); i++) {
            hashcode+=str.charAt(i)-('a'-1);
        }
        return hashcode;
    }

    public static void main(String[] args) {
        String str="hello world";
        String pattern="hello";
        System.out.println(pattern+"在"+str+"中的起始位置是"+robinKarp(str,pattern));
    }
}
