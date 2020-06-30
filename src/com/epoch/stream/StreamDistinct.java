package com.epoch.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDistinct {

    public static void main(String[] args) {

        testDistinct();

        System.out.println("================================");

        testSort();

        System.out.println("================================");

        testCollectSort();

        System.out.println("================================");

        testLimit();

        System.out.println("================================");

        testSkip();

        System.out.println("================================");

        testReduce();

    }

    private static void testReduce() {

        List<String> list = Arrays.asList("W", "o", "r", "l", "d", "!");

        String appendStr = list.stream().reduce("Hello,", (a, b) -> (a + b));

        System.out.println(appendStr);

    }

    private static void testSkip() {

        List<String> list = Arrays.asList("111", "222", "333");

        list.stream().skip(2).forEach(System.out::println);
    }

    private static void testLimit() {

        List<String> list = Arrays.asList("111", "222", "333");

        list.stream().limit(2).forEach(System.out::println);
    }

    private static void testCollectSort() {

        Student s1 = new Student("张三", 2L, 22, "成都");

        Student s2 = new Student("李四", 3L, 22, "重庆");

        Student s3 = new Student("王二", 4L, 23, "成都");

        Student s4 = new Student("麻子", 5L, 24, "绵阳");


        List<Student> studentList = new ArrayList<>();

        studentList.add(s1);

        studentList.add(s2);

        studentList.add(s3);

        studentList.add(s4);

        studentList.stream().sorted((stu1,stu2)->Long.compare(stu2.getId(),stu1.getId()))
                            .sorted((stu1,stu2)->Integer.compare(stu2.getAge(),stu1.getAge()))
                            .forEach(System.out::println);
    }


    private static void testSort() {

        List<String> list = Arrays.asList("111", "333", "222", "444", "333");

        list.stream().sorted().forEach(a-> System.out.println(a));
    }

    private static void testDistinct() {

        List<String> list = Arrays.asList("111", "333", "222", "444", "333");

        List<String> collect = list.stream().distinct().collect(Collectors.toList());

        //collect.forEach(System.out::println);

        collect.forEach(a-> System.out.println(a));

    }
}
