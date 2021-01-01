package com.testspringboot.springboottest.reflect;


import com.testspringboot.springboottest.model.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author xiexusheng
 * @date 2021/1/1 - 20:35
 */
public class ReflectDemo2 {

    /**
     * 获取方法的使用方法
     * @param args
     * @throws Exception
     */

    public static void main (String[] args) throws Exception{

        Class<Person> personClass = Person.class;
        //获取指定方法且是public修饰的方法
        Method eatMethod = personClass.getMethod("eat");
        Person person = personClass.newInstance();
        eatMethod.invoke(person);

        //获取指定方法且是public修饰的带有参数的方法
        Method eatMethods = personClass.getMethod("eat", String.class);
        eatMethods.invoke(person,"吃牛排");

        //获取所有public修饰的方法包括父类里的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            //暴力反射可以运行私有的方法
            method.setAccessible(true);
            //获取方法名
            System.out.println(method.getName());
        }
        //获取类名
        String name = personClass.getName();
        //com.testspringboot.springboottest.model.Person
        System.out.println(name);
    }

}
