package com.epoch.util;

import java.io.*;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/7/28
 */
public class CloneUtils {
    public static <T extends Serializable> T clone(T obj){
        T cloneObj = null;
        try{
            //写入字节流
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();

            //分配内存;写入原始对象,生成新对象
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            //返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return cloneObj;
    }
}
