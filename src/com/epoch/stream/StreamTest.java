package com.epoch.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        Student s1 = new Student("张三", 1L, 20, "成都");

        Student s2 = new Student("李四", 3L, 20, "重庆");

        Student s3 = new Student("王二", 4L, 23, "成都");

        Student s4 = new Student("麻子", 5L, 24, "绵阳");

        Student s5 = new Student("麻子", 5L, 24, "绵阳");

        List<Student> studentList = new ArrayList<>();

        studentList.add(s1);

        studentList.add(s2);

        studentList.add(s3);

        studentList.add(s4);

        studentList.add(s5);

        List<Student> studentStream=testFilter(studentList);

        studentStream.forEach(System.out::println);

        testMap(studentList);

        //集合去重
        studentList.stream().distinct().forEach(System.out::println);

    }

    private static void testMap(List<Student> studentList) {

        List<String> collect = studentList.stream().map(s -> "住址:" + s.getAddress()).collect(Collectors.toList());

        collect.forEach(a-> System.out.println(a));
    }

    private static List<Student> testFilter(List<Student> studentList) {

        //找出年龄大于20岁的学生信息
        //return studentList.stream().filter(s -> s.getAge()>20).collect(Collectors.toList());

        //找出住在成都的学生信息
        return studentList.stream().filter(s ->"成都".equals(s.getAddress())).collect(Collectors.toList());
    }

}
