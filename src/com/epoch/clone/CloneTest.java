package com.epoch.clone;

import com.epoch.util.CloneUtils;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/7/28
 */
public class CloneTest {

    public static void main(String[] args) {

        Person p1 = new Person("张三");

        Person p2 = CloneUtils.clone(p1);
        p2.setName("李四");

        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}
