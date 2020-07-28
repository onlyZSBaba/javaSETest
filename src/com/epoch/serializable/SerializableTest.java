package com.epoch.serializable;

import java.io.*;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/7/28
 */
public class SerializableTest {

    public static void main(String[] args) {

        User user = new User("张三");
        User userObj = null;
        try {
            //将对象写入到文件(序列化)
            /*ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("template"));
            oos.writeObject(user);
            oos.flush();
            oos.close();*/

            //序列化完成后修改User表中的serialVersionUID,反序列化时会抛出异常

            //反序列化
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("template"));
            userObj = (User) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(userObj);
    }
}
