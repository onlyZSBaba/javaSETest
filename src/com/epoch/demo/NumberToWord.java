package com.epoch.demo;


public class NumberToWord {

    public static void main(String[] args) {

        String convert = convert(1211201);

        if(convert.length()>1){
            convert+="整";
        }
        System.out.println(convert);
    }


    public static String convert(int number) {
        String[] single = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};//汉字一到九
        String[] unit = {"", "十", "百", "千", "万", "亿"};//汉字单位
        StringBuilder sb = new StringBuilder();
        int[] unitInt = {100000000, 10000, 1000, 100, 10};

        int m = 0;
        int tmp = -1;


        for (int i : unitInt) {

            int n = number / i;
            number = number % i;
            if (sb.length() != 0 || n != 0) {
                if (n > single.length - 1) {
                    String cc = convert(n);
                    sb.append(cc);
                } else {
                    if (0==tmp && 0==n) {

                    } else {
                        sb.append(single[n]);
                    }

                    tmp = n;
                }
                if (n != 0) {
                    sb.append(unit[unit.length - 1 - m]);
                }

            }
            m++;

        }
        if (number != 0) {
            sb.append(single[number]);
        }
        String ret = sb.toString();
        if (ret.length()==0){
            return "零";
        }

        String last = String.valueOf(ret.charAt(ret.length() - 1));
        if ("零".equals(last)) {
            ret = ret.substring(0, ret.length() - 1);
        }

        return ret;
    }
}
