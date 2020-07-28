package com.epoch.serializable;

import java.io.Serializable;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/7/28
 */
public class User implements Serializable {

    private static final long serialVersionUID = 123456L;

    private String name;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

}
