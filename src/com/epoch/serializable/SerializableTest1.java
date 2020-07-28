package com.epoch.serializable;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/7/28
 */
public class SerializableTest1 {

    public static void main(String[] args) {

        User1 user1 = new User1("张三");
        System.out.println("序列化之前："+user1.getName());

        User1 userObj = null;
        try{
            //序列化
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("template1"));
            oos.writeObject(user1);
            oos.flush();
            oos.close();

            //反序列化
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("template1"));
            userObj = (User1) ois.readObject();
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("序列化之后："+userObj.getName());
    }
}
