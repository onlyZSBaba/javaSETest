package com.epoch.serializable;

import java.io.*;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/7/28
 */
public class User1 implements Externalizable {

    private static final long serialVersionUID = 123456L;

    private transient String name;

    public User1(String name) {
        this.name = name;
    }

    public User1() {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
    }
}
